package app.bangkit.notification.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import app.bangkit.notification.R

object AppNotification {

    fun simpleNotification(
        context: Context,
        title: String,
        content: String
    ) {
        // first, you've to define the channel id and the notif id
        val channelId = "bangkit_notification"
        val notificationId = 9898

        // second, preparing the notification using the notif service
        val notificationManager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        // preparing the notification
        val builder = NotificationCompat
            .Builder(context, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(content)

        // create the notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Notifikasi Waktu",
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationManager.createNotificationChannel(channel)
        }

        val notification = builder.build()

        // rendering our notification using notifManager
        notificationManager.notify(notificationId, notification)
    }

}