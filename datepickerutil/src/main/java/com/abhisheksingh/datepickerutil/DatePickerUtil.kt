package com.abhisheksingh.datepickerutil

import android.app.DatePickerDialog
import android.content.Context
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

open class DatePickerUtil
{
   open  fun simpleDatePicker(simpleDateFormat: String, context: Context,listener:DatePickerResultCallback ) {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpDialog = DatePickerDialog(
            context,
            DatePickerDialog.OnDateSetListener { view, year: Int, monthOfYear: Int, dayOfMonth: Int ->


                val fmt = SimpleDateFormat("dd/MM/yyyy")
                val month = monthOfYear + 1
                val date = fmt.parse("$dayOfMonth/$month/$year")

                val fmtOut = SimpleDateFormat(simpleDateFormat)

                listener.dateResult(fmtOut.format(date))

            }, year, month, day
        )

        var datePicker = dpDialog.datePicker
        var calendar = Calendar.getInstance()
        datePicker.maxDate = calendar.timeInMillis

        dpDialog.show()

    }







}