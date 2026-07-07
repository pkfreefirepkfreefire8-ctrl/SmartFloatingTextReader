package com.smartreader.app.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    companion object {
        private const val PREFS_NAME = "smart_reader_prefs"
        const val KEY_SPEECH_RATE = "speech_rate"
        const val KEY_PITCH = "pitch"
        const val KEY_LANGUAGE = "language"
        const val KEY_DARK_MODE = "dark_mode"
        const val KEY_VOICE_FEEDBACK = "voice_feedback"
        const val KEY_FLOATING_BUTTON_X = "floating_button_x"
        const val KEY_FLOATING_BUTTON_Y = "floating_button_y"
        const val KEY_IS_SERVICE_RUNNING = "is_service_running"
        const val DEFAULT_SPEECH_RATE = 0.8f
        const val DEFAULT_PITCH = 1.0f
        const val DEFAULT_LANGUAGE = "en"
    }

    var speechRate: Float
        get() = prefs.getFloat(KEY_SPEECH_RATE, DEFAULT_SPEECH_RATE)
        set(value) = prefs.edit().putFloat(KEY_SPEECH_RATE, value).apply()

    var pitch: Float
        get() = prefs.getFloat(KEY_PITCH, DEFAULT_PITCH)
        set(value) = prefs.edit().putFloat(KEY_PITCH, value).apply()

    var language: String
        get() = prefs.getString(KEY_LANGUAGE, DEFAULT_LANGUAGE) ??: DEFAULT_LANGUAGE
        set(value) = prefs.edit().putString(KEY_LANGUAGE, value).apply()

    var isDarkMode: Boolean
        get() = prefs.getBoolean(KEY_DARK_MODE, false)
        set(value) = prefs.edit().putBoolean(KEY_DARK_MODE, value).apply()

    var voiceFeedback: Boolean
        get() = prefs.getBoolean(KEY_VOICE_FEEDBACK, true)
        set(value) = prefs.edit().putBoolean(KEY_VOICE_FEEDBACK, value).apply()

    var floatingButtonX: Int
        get() = prefs.getInt(KEY_FLOATING_BUTTON_X, -1)
        set(value) = prefs.edit().putInt(KEY_FLOATING_BUTTON_X, value).apply()

    var floatingButtonY: Int
        get() = prefs.getInt(KEY_FLOATING_BUTTON_Y, -1)
        set(value) = prefs.edit().putInt(KEY_FLOATING_BUTTON_Y, value).apply()

    var isServiceRunning: Boolean
        get() = prefs.getBoolean(KEY_IS_SERVICE_RUNNING, false)
        set(value) = prefs.edit().putBoolean(KEY_IS_SERVICE_RUNNING, value).apply()
}