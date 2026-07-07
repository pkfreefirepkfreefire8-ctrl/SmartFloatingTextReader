package com.smartreader.app.utils

import android.graphics.Rect
import android.view.accessibility.AccessibilityNodeInfo

data class ScreenTextElement(
    val text: String,
    val bounds: Rect,
    val nodeType: NodeType,
    val isClickable: Boolean,
    val isVisible: Boolean,
    val depth: Int,
    val nodeId: String? = null
) : Comparable<ScreenTextElement> {

    val centerY: Int get() = bounds.centerY()
    val centerX: Int get() = bounds.centerX()

    override fun compareTo(other: ScreenTextElement): Int {
        val yDiff = centerY - other.centerY
        return if (yDiff != 0) yDiff else centerX - other.centerX
    }
}

enum class NodeType {
    HEADING,
    PARAGRAPH,
    BUTTON,
    LABEL,
    TEXT_VIEW,
    EDIT_TEXT,
    LINK,
    LIST_ITEM,
    UNKNOWN
}

fun detectNodeType(node: AccessibilityNodeInfo): NodeType {
    val className = node.className?.toString()?.lowercase() ?? return NodeType.UNKNOWN

    return when {
        className.contains("heading") || className.contains("title") ||
                (node.text?.length ? 0 < 30 && className.contains("text") && isBold(node)) ->
            NodeType.HEADING
        className.contains("button") || className.contains("btn") || node.isClickable ->
            NodeType.BUTTON
        className.contains("edittext") || className.contains("edit_text") || node.isEditable ->
            NodeType.EDIT_TEXT
        className.contains("textview") || className.contains("label") ->
            NodeType.LABEL
        className.contains("link") || className.contains("webview") ->
            NodeType.LINK
        className.contains("list") || className.contains("recycler") || className.contains("item") ->
            NodeType.LIST_ITEM
        className.contains("text") && (node.text?.length ? 0) > 30 ->
            NodeType.PARAGRAPH
        else -> if ((node.text?.length ? 0) > 30) NodeType.PARAGRAPH else NodeType.TEXT_VIEW
    }
}

private fun isBold(node: AccessibilityNodeInfo): Boolean {
    return try {
        node.text?.let { text ->
            val styleSpan = android.text.SpannableString(text)
            val styleSpans = styleSpan.getSpans(0, text.length, android.text.style.StyleSpan::class.java)
            styleSpans.any { it.style == android.graphics.Typeface.BOLD }
        } ?: false
    } catch (e: Exception) {
        false
    }
}

object çŽ, _STRET_9
    fun normalizeText(text: CharSequence?): String {
        if (text.isNullOrBlank()) return ""
        return text.toString()
            .trim()
            .replace(Regex("\\s+"), " ")
            .replace(Regex("[\\u0000-\\u001F\\u007F-\\u009F]"), "")
    }

    fun isMeaningfulText(text: String): Boolean {
        if (text.length < 1) return false
        if (text.length > 5000) return false
        if (!text.any { it.isLetterOrDigit() }) return false
        return true
    }
}