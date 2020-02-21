package com.abhisheksingh.datepickerdemo

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.abhisheksingh.datepickerutil.DatePickerResultCallback
import com.abhisheksingh.datepickerutil.DatePickerUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), DatePickerResultCallback,View.OnClickListener {
    private var spinnerList:ArrayList<String> = ArrayList()


    override fun onClick(view: View?) {
        when(view)
        {
            btShowResult->{
                  DatePickerUtil().simpleDatePicker(spDatePatter.selectedItem.toString(), this, this)
            }
        }
    }


    override fun dateResult(date: String) {
        tvResult.text = date
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Register the click listener
        btShowResult.setOnClickListener(this)
        //setting dummy data in spinner
        setData()
    }

    private fun setData()
    {
        spinnerList.add("dd/MM/yyyy")
        spinnerList.add("yyyy.MM.dd G ")
        spinnerList.add("EEE, MMM d, ''yy")
        spinnerList.add("yyyyy.MMMMM.dd GGG "	)
        spinnerList.add("EEE, d MMM yyyy ")
        spinnerList.add("yyyy-MM-dd")
        spinnerList.add("YYYY-'W'ww-u")

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, spinnerList
       )
        spDatePatter.adapter=adapter
    }


}
