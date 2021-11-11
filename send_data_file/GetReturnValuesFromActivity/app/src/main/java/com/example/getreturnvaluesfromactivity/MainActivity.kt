package com.example.getreturnvaluesfromactivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
            private val getResult =
                registerForActivityResult(
                    ActivityResultContracts.StartActivityForResult()) { res->
                    if(res.resultCode == Activity.RESULT_OK){
                        val value = res.data?.getIntExtra("result", 0)
                        Log.d("DKMobile", "Received Result is "+value.toString())
                        val mainResultView = findViewById<TextView>(R.id.returnTxt  )
                        mainResultView.text = "Result is "+value.toString()
                    }
                }

            override fun onCreate(savedInstanceState: Bundle?) {

            Log.d("DKMobile","MainActivity onCreate()")

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val intentMain = Intent(this,SubActivity::class.java)
            val calcBtn = findViewById<Button>(R.id.calcBtn)

            calcBtn.setOnClickListener {

                Log.d("DKMobile","OPEN SUB button pressed")
                val num1W = findViewById<EditText>(R.id.num1)
                val num2W = findViewById<EditText>(R.id.num2)
                var  num1 = num1W.text.toString().toInt()
                var  num2 = num2W.text.toString().toInt()

                intentMain.putExtra("num1Extra",num1)
                intentMain.putExtra("num2Extra",num2)

                Log.d("DKMobile","putExtra" + num1.toString() + "," + num2.toString())

                getResult.launch(intentMain)
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
