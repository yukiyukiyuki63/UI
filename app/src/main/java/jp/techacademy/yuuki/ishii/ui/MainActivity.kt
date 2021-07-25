package jp.techacademy.yuuki.ishii.ui

import android.app.TimePickerDialog
import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
//import android.widget.EdgeEffect
//import android.widget.EditText
import android.util.Log
import android.view.View
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener (this)
        button3.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button1 -> textView.text = editText.text.toString()
            R.id.button3 -> showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if(hour in 2..9){
                    textView.text = "おはよう"
                } else if(hour in 10..18){
                    textView.text = "こんにちは"
                } else{
                    textView.text = "こんばんは"
                }
            },
        13,0,true)
        timePickerDialog.show()
    }
}