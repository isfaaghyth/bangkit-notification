package app.bangkit.notification.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private var listener: DatePickerListener? = null

    // set the listener callback from activity to this class
    fun setResult(listener: DatePickerListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // first, we trying to getting the current date
        val calendar = Calendar.getInstance()

        // second, getting the year, month, and date
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val date = calendar.get(Calendar.DATE)

        return DatePickerDialog(
            activity as Context,
            this,
            year,
            month,
            date
        )
    }

    override fun onDateSet(
        view: DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        listener?.result(year, month, dayOfMonth)
    }

    interface DatePickerListener {
        fun result(year: Int, month: Int, dayOfMonth: Int)
    }

}