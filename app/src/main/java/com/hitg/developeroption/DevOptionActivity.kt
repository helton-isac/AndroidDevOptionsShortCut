package com.hitg.developeroption

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity

class DevOptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS))
        // attempt to avoid start the activity (Useless on this version)
        finish()
    }

    override fun onResume() {
        super.onResume()
        // To assure the activity will close if started for any reason
        finish()
    }
}