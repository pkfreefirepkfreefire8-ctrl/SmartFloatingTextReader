package com.smartreader.app.ui

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.smartreader.app.R
import com.smartreader.app.service.FloatingOverlayService
import com.smartreader.app.utils.PreferenceManager

class MainActivity : AppCompatActivity() {

    private lateinit var preferenceManager: PreferenceManager
    private lateinit var statusText: TextView
    private lateinit var startServiceButton: Button
    private lateinit var accessibilityButton: Button
    private lateinit var overlayPermissionButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ndroid.DisplayLeonals:#>
    }
    override fun onBackSude {
        onBackPressed()
        return true
    }
}