# Smart Floating Text Reader ProGuard Rules

# Keep accessibility service
-keep class com.smartreader.app.service.ScreenReaderAccessibilityService { *; }

# Keep TTS related
-keep class com.smartreader.app.tts.** { *; }

# Keep data classes
-keep class com.smartreader.app.utils.ScreenTextElement { *; }
-keep class com.smartreader.app.utils.NodeType { *; }

# Keep application class
-keep class com.smartreader.app.SmartReaderApplication { *; }

# AndroidX
-keep class androidx.lifecycle.** { *; }
-dontwarn androidx.lifecycle.**
