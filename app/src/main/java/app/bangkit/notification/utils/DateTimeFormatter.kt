package app.bangkit.notification.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeFormatter {

    fun formatDate(
        year: Int,
        month: Int,
        dayOfMonth: Int
    ): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

        return dateFormat.format(calendar.time)
    }

    fun formatTime(
        hour: Int,
        minute: Int
    ): String {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)

        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())

        return dateFormat.format(calendar.time)
    }

}