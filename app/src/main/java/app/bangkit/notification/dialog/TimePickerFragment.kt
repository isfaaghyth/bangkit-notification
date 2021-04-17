package app.bangkit.notification.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    private var listener: TimePickerListener? = null

    fun setResult(listener: TimePickerListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // first, getting the current time
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        val isFormatTime24 = true

        return TimePickerDialog(
            activity as Context,
            this,
            hour,
            minute,
            isFormatTime24
        )
    }

    override fun onTimeSet(
        view: TimePicker?,
        hour: Int,
        minute: Int
    ) {
        listener?.onTimeResult(hour, minute)
    }

    interface TimePickerListener {
        fun onTimeResult(hour: Int, minute: Int)
    }

}