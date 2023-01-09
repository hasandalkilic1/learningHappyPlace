package com.happyplaces

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_add_happy_place.*
import java.text.SimpleDateFormat
import java.util.*



class AddHappyPlaceActivity : AppCompatActivity(),View.OnClickListener {

    var cal =Calendar.getInstance()
    private lateinit var dateSetListener: DatePickerDialog.OnDateSetListener

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_happy_place)

        setSupportActionBar(toolbar_add_place) // Use the toolbar to set the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // This is to use the home back button.

        toolbar_add_place.setNavigationOnClickListener {
            onBackPressed()
        }
        dateSetListener=DatePickerDialog.OnDateSetListener {
                view, year, month, day ->
            cal.set(Calendar.YEAR,year)
            cal.set(Calendar.MONTH,month)
            cal.set(Calendar.DAY_OF_MONTH,day)
            updateDateInView()
        }

        et_date!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.et_date ->{
                DatePickerDialog(
                    this@AddHappyPlaceActivity,
                    dateSetListener,cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        }
    }

    private fun updateDateInView(){
        val myFormat="dd.MM.yyyy"
        val sdf=SimpleDateFormat(myFormat,Locale.getDefault())
        et_date.setText(sdf.format(cal.time).toString())

    }
}