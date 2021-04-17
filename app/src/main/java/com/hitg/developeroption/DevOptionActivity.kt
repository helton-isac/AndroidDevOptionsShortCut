package com.hitg.developeroption

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DevOptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = DevOptionUtil.getMostAppropriateIntent(this)
        startActivity(intent)
        // attempt to avoid start the activity (Useless on this version)
        finish()
    }

    override fun onResume() {
        super.onResume()
        // To assure the activity will close if started for any reason
        finish()
    }
}