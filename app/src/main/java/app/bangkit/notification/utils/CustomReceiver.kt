package app.bangkit.notification.utils

import android.content.Context
import android.content.Intent

// custom broadcast
const val ACTION_CUSTOM_BROADCAST = "app.bangkit.notification.CURRENT_TIME"

// the key of intent of CURRENT_TIME
const val KEY_CURRENT_TIME = "current_time"

fun Context.currentTimeBroadcast(currentTime: String) {
    val intent = Intent(ACTION_CUSTOM_BROADCAST)
    intent.putExtra(KEY_CURRENT_TIME, currentTime)
    sendBroadcast(intent)
}