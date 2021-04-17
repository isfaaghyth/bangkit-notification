package app.bangkit.notification.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import app.bangkit.notification.utils.ACTION_CUSTOM_BROADCAST
import app.bangkit.notification.utils.AppNotification
import app.bangkit.notification.utils.KEY_CURRENT_TIME

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            ACTION_CUSTOM_BROADCAST -> {
                val currentTime = intent.extras?.getString(KEY_CURRENT_TIME)

                AppNotification.simpleNotification(
                    context = context,
                    title = "Current Time!",
                    content = "We got the current time is $currentTime"
                )
            }
        }
    }

}