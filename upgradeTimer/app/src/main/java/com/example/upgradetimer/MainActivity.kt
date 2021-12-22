package com.example.upgradetimer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView

//class MyHandler : Handler(Looper.getMainLooper()) {
//        override fun handleMessage(msg: Message) {
//            super.handleMessage(msg)
////            val helloText = findViewById<TextView>(R.id.helloText)
//
//            Log.d("BkgThread", "Main thread")
////            if(msg.what == 1) {
////                helloText.setText("$msg.arg1")
////            }
//        }
//}

var started = false
var pause = false
var time_value = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timerText = findViewById<TextView>(R.id.timerText)
        val buttonStart = findViewById<Button>(R.id.buttonStart)
        val buttonStop = findViewById<Button>(R.id.buttonStop)
        val buttonPause = findViewById<Button>(R.id.buttonPause)

        val sharedPref = getSharedPreferences("kr.ac.dankook.example.Shared_pref", Context.MODE_PRIVATE)


        val time = sharedPref.getString("time", "0").toString()
        time_value = sharedPref.getInt("time_value",0);

        Log.d("DKMOB",time + " " + time_value)

        val min = String.format("%02d", time_value/60)
        val sec = String.format("%02d", time_value%60)
        timerText.text = "$min:$sec"


        val myHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                Log.d("BkgThread", "Main thread")
                if (msg.what == 1) {
                    val min = String.format("%02d", msg.arg1 / 60)
                    val sec = String.format("%02d", msg.arg1 % 60)
                    timerText.text = "$min:$sec"

                    if(pause){
                        val editor = sharedPref.edit()
                        editor.putString("time",min+":"+sec)
                        editor.putInt("time_value", time_value)
                        editor.apply()
                    }
                }
            }
        }

        Thread {

            //var i = 0
            while (true) {
                Thread.sleep(1000)
                if (started) {

                    var msg = myHandler.obtainMessage()
                    msg.what = 1
                    msg.arg1 = time_value
                    myHandler.sendMessage(msg)
                    time_value += 1


                } else if (pause) {

                } else {
                    time_value = 0
                }
            }
        }.start()



        buttonStart.setOnClickListener {
            started = true
            pause = false
        }

        buttonStop.setOnClickListener {
            started = false
            pause = false
        }

        buttonPause.setOnClickListener {
            pause = true

            if (started) {
                started = false
            } else
                started = true



        }
    }
}