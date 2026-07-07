package com.smartreader.app

import android.app.Application
import com.smartreader.app.utils.PreferenceManager

class SmartReaderApplication : Application() {

    lateinit var preferenceManager: PreferenceManager
        private set

    override fun onCreate() {
        super.onCreate()
        preferenceManager = PreferenceManager(this)
    }
}