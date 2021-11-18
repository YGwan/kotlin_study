package com.example.getthecamerapermission

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cameraBtn = findViewById<Button>(R.id.cameraBtn)
        var textViewTxt = findViewById<TextView>(R.id.textViewTxt)

        cameraBtn.setOnClickListener {

            Log.d(TAG, "click camera Btn")

            //Camera가 허용되있는지 확인
            val cameraPermission =
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

            //

            //허용되어있으면 실행
            if (cameraPermission == PackageManager.PERMISSION_GRANTED) {

                textViewTxt.setText("CAMERA permission granted now")
                Log.d(TAG, "camera permission already granted")


            } else {
                textViewTxt.setText( "CAMERA permission not granted")
                Log.d(TAG, "camera permission don't granted")

                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 99)

            }


        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        var textViewTxt = findViewById<TextView>(R.id.textViewTxt)

        when(requestCode) {
            99 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    //사용자가 권한을 허용할 때 다음 작업을 수행합니다.
                    textViewTxt.setText("CAMERA permission granted now")
                    Log.d("DKMOBILE", "CAMERA permission newly granted")

                }else {

                    //사용자가 권한을 허용하지 않을때 다음 작업을 수행합니다.
                    textViewTxt.setText( "CAMERA permission not granted")
                    Log.d("DKMOBILE", "CAMERA permission not granted")

                }
            }

        }
    }
}