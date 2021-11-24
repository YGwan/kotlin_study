package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private var tag = MainActivity::class.java.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //To write a key-value pair

        //Get a handle to share preferences - 기본 설정을 공유할 handle 가져오기
        val sharedPref = getSharedPreferences("com.example.SHARED_PREF_File", Context.MODE_PRIVATE)

        //text하고 button 연결하기

        val usernameTxt = findViewById<EditText>(R.id.usernameTxt)
        val passwordTxt = findViewById<EditText>(R.id.passwordTxt)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        //데이터 값이 없으면 기본값으로 할당하기

        val username: String = "unknown"
        val password: String = "****"
        val id = -1

        Log.d(tag,username.toString() +", "+ password.toString()  +", "+ id.toString())
        Log.d(tag,"저장된 로그인 정보가 없습니다. 값 입력 후, 로그인 버튼을 눌러주세요.")

        //create editor - editor 생성
        val editor = sharedPref.edit()

        //Write to shared preferences - 공유할 preference(username, pwd, id)를 쓰기

        loginBtn.setOnClickListener {

            editor.putString("username", usernameTxt.text.toString())
            editor.putString("password", passwordTxt.text.toString())
            editor.putInt("id", 1)

            // call apply - to save value in the file(apply method 부르기)
            editor.apply()


            val username: String? = sharedPref.getString("username","unknown")
            val password: String? = sharedPref.getString("password","****")
            val id = sharedPref.getInt("id",-1)

            Log.d(tag,username.toString() +", "+ password.toString()  +", "+ id.toString())
            Log.d(tag,"값 저장을 완료했습니다. 파일을 확인해보세요.")
        }

    }

}