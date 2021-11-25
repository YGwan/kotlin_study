package com.example.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //변수 설정
        val timeTxt = findViewById<TextView>(R.id.timeTxt)
        val startBtn = findViewById<Button>(R.id.startBtn)
        val stopBtn = findViewById<Button>(R.id.stopBtn)
        var started = false
        var event = true

        //Handler 클래스의 개체를 만듭니다. Looper object.getMainLooper() 메서드가 Main 스레드의 루프를 반환해야 합니다.
        val myHandler = object : Handler(Looper.getMainLooper()) {

            //수신된 메시지를 처리하도록 handleMessage() 메서드를 재정의합니다.
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                val timeTxt = findViewById<TextView>(R.id.timeTxt)

                Log.d("BkgThread", "Main thread")

                //프로세스가 handleMessage() 메서드로 메시지를 수신
                if (msg.what == 1) {
                    val fm = DecimalFormat("00") //10의자리로 값을 모두 다 표현
                    timeTxt.setText("${fm.format(msg.arg2)}:${fm.format(msg.arg1)}")
                }
                if (msg.what == 2) {
                    timeTxt.setText("00:00")
                }
            }
        }

       // Update Text in background thread

        Thread {
            var i = 0
            var hour = 0

            while (true) {
                Thread.sleep(1000)

                if(started){
                    i += 1
                    if(i==59){
                        hour += 1
                        i = 0
                    }

                    Log.d("BkgThread", "In background thread : $i")
                    var msg = myHandler.obtainMessage() //메시지를 보낼 메시지 개체 가져오기

                    msg.what = 1//메시지를 구분하기 위한 "what"

                    //arg1 & arg2 속성을 사용하여 단순 정수 데이터 전송
                    msg.arg1 = i
                    msg.arg2 = hour

                    //main 스레드의 메시지 큐에 메시지를 보내기 위해 senMessage() 메서드를 호출
                    myHandler.sendMessage(msg)
                }

                else{
                    i = 0
                    hour = 0
                }

            }
        }.start()

        startBtn.setOnClickListener {

            if(event) {
                started = true
                event = false
            }

            else {
                var msg = myHandler.obtainMessage()
                msg.what = 2
                myHandler.sendMessage(msg)
                event = true
                started = true
            }
        }

        stopBtn.setOnClickListener {
            started = false
        }

    }
}