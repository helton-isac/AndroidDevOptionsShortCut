package com.hitg.developeroption

import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.service.quicksettings.TileService
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)
class DevOptionTileService : TileService() {
    override fun onClick() {
        super.onClick()
        val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
        startActivityAndCollapse(intent)
    }
}