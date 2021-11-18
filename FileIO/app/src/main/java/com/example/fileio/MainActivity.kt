package com.example.fileio

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //파일 이름 지정
        val fileName = "internal.txt"

        //파일 내용 지정
        val fileBody = "File for testing"

        //androidstudio에서 값을 써서 파일에 값 전달하기
        //파일을 열고(없으면 만들어서 열고) 수정할 수 있는 상태를 만든다. 이때 파일은 fileName이다.
        val buffo = applicationContext.openFileOutput(fileName, Context.MODE_PRIVATE)

        //fileBody에 내용을 가져와 쓴다.
        buffo.write(fileBody.toByteArray())
        buffo.close()

        //파일에 있는 내용을 읽어서 android studio에 값 전달하기
        val buffi = applicationContext.openFileInput(fileName)
        val buffr = buffi.bufferedReader()
        var txt = buffr.readLine()
        buffr.close()

        val textView = findViewById<TextView>(R.id.textView)
        textView.setText(txt.toString())



    }
}