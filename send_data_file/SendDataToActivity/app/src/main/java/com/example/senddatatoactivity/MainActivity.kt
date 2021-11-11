package com.example.senddatatoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentMain = Intent(this,SubActivity::class.java)

        val calcBtn = findViewById<Button>(R.id.calcBtn)

        calcBtn.setOnClickListener {

            val num1W = findViewById<EditText>(R.id.num1)
            val num2W = findViewById<EditText>(R.id.num2)

            var num1 = num1W.text.toString().toInt()
            var num2 = num2W.text.toString().toInt()

            intentMain.putExtra("num1Extra", num1)
            intentMain.putExtra("num2Extra", num2)

            startActivity(intentMain)

        }


    }
}