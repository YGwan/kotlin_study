package com.example.usingroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.room.User
import com.example.room.UserDB

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Use database in your app
        val db = Room.databaseBuilder(
            applicationContext, UserDB::class.java, "userDataBase" //database-name
        ).allowMainThreadQueries().build()
        //database는 많은 데이터를 가질 수 있기 때문에 main에서 읽으면 앱이 정지한 것처럼 보일 수 있다.
        //따라서  안드로이드는 이것을 막아놨고, 이것을 해결하기 위해 main thread에서 데이터를 접근한다.
        //이때 사용하는 명령어가 allowMainTreadQueries()이다.



        val users = db.userDao().getAll()

        if(users.isNotEmpty()) {
            Log.d(TAG,"something in db")
        } else {
            val d = Log.d(TAG, "Nothing in db")
        }

        //Log.d(TAG, "입력을 시작합니다.")
        //Insert data to database

        //val userd = User(1, "YongGwan", "Park")
        //db.userDao().insertAll(userd)


        //Query specific data from database
        var readuser = db.userDao().findByName("YongGwan", "Park")
        if (readuser != null) {
            Log.d(TAG,readuser.firstName+" "+readuser.lastName)

        } else {

        }
//
//        var readuser2 = db.userDao().findByName("W%", "%")
//        if (readuser2 != null) {
//            Log.d(TAG,readuser2.firstName+" "+readuser2.lastName)
//
//        } else {
//
//        }

    }
}