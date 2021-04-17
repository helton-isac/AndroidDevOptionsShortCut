package com.hitg.developeroption

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi

object DevOptionUtil {

    fun getMostAppropriateIntent(context: Context): Intent {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (isDevelopmentsSettingsEnabled(context)) {
                getIntentToDevOption()
            } else {
                Toast.makeText(context, context.getString(R.string.you_need_enable_dev_options), Toast.LENGTH_LONG).show()
                getIntentToDeviceSettings()
            }
        } else {
            getIntentToDevOption()
        }
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private fun isDevelopmentsSettingsEnabled(context: Context) = Settings.Secure.getInt(
        context.contentResolver,
        Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0
    ) != 0


    private fun getIntentToDevOption(): Intent {
        return Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
    }

    private fun getIntentToDeviceSettings(): Intent {
        return Intent(Settings.ACTION_DEVICE_INFO_SETTINGS)
    }
}

