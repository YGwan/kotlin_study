package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.lang.Math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val tallField = findViewById<TextView>(R.id.tallField)
            val tall: Double = tallField.text.toString().toDouble()
            val weightField = findViewById<TextView>(R.id.weightField)
            val weight = weightField.text.toString().toDouble()

            val bmi = ceil(weight/Math.pow(tall/100, 2.0))

            var resultLabel = findViewById<TextView>(R.id.resultLabel)
            resultLabel.setText("키: ${tall}, 몸무게: ${weight}, bmi는 ${bmi}이다")

        }
    }
}