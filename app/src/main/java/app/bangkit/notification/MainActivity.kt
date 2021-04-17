package app.bangkit.notification

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.bangkit.notification.databinding.ActivityMainBinding
import app.bangkit.notification.dialog.DatePickerFragment
import app.bangkit.notification.dialog.TimePickerFragment
import app.bangkit.notification.receiver.NotificationReceiver
import app.bangkit.notification.utils.ACTION_CUSTOM_BROADCAST
import app.bangkit.notification.utils.DateTimeFormatter.formatDate
import app.bangkit.notification.utils.DateTimeFormatter.formatTime
import app.bangkit.notification.utils.currentTimeBroadcast

class MainActivity : AppCompatActivity(),
        DatePickerFragment.DatePickerListener,
        TimePickerFragment.TimePickerListener {

    private lateinit var binding: ActivityMainBinding
    private val receiver = NotificationReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowDialog.setOnClickListener {
//            val dialog = DatePickerFragment()
//            dialog.setResult(this)
//            dialog.show(supportFragmentManager, "date_picker")

            val timeDialog = TimePickerFragment()
            timeDialog.setResult(this)
            timeDialog.show(supportFragmentManager, "time_picker")
        }

        binding.btnReceiver.setOnClickListener {
            val intentFilter = IntentFilter(ACTION_CUSTOM_BROADCAST)
            registerReceiver(receiver, intentFilter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // we must unregister the receiver if the app is no longer
        unregisterReceiver(receiver)
    }

    override fun result(year: Int, month: Int, dayOfMonth: Int) {
        binding.txtResult.text = formatDate(year, month, dayOfMonth)
    }

    override fun onTimeResult(hour: Int, minute: Int) {
        val formatTime = formatTime(hour, minute)

        binding.txtResult.text = formatTime
        currentTimeBroadcast(formatTime)
    }

}