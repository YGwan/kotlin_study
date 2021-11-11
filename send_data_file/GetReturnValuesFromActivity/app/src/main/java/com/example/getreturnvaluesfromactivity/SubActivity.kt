package com.example.getreturnvaluesfromactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DKMobile","MainActivity onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intentSub = intent

        val num1R = intentSub.getIntExtra("num1Extra",0)
        val num2R = intentSub.getIntExtra("num2Extra",0)

        Log.d("DKMobile","getExtra" + num1R.toString() + "," + num2R.toString() + " Result=" + (num1R+num2R).toString())

        val resultTxt = findViewById<TextView>(R.id.resultTxt)

        resultTxt.text = num1R.toString() + "+" + num2R.toString() + "=" + (num1R+num2R).toString()

        val returnBtn = findViewById<Button>(R.id.returnBtn)

        returnBtn.setOnClickListener {

            Log.d("DKMobile","Return button pressed")
            val outIntent = Intent(this,MainActivity::class.java)
            outIntent.putExtra("result", num1R+num2R)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }




    }

    override fun onStart() {
        Log.d("DKMobile","MainActivity onStart()")
        super.onStart()
    }

    override fun onRestart() {
        Log.d("DKMobile","MainActivity onRestart()")
        super.onRestart()
    }

    override fun onResume() {
        Log.d("DKMobile","MainActivity onResume()")
        super.onResume()
    }

    override fun onPause() {
        Log.d("DKMobile","MainActivity onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.d("DKMobile","MainActivity onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("DKMobile","MainActivity onDestroy()")
        super.onDestroy()
    }
}