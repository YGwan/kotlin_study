package com.example.problem1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textEx = findViewById<TextView>(R.id.textView)



        var button1 = findViewById<Button>(R.id.button1)
        var button2 = findViewById<Button>(R.id.button2)
        var button19 = findViewById<Button>(R.id.button19)
        var button20 = findViewById<Button>(R.id.button20)
        var button21 = findViewById<Button>(R.id.button21)
        var button22 = findViewById<Button>(R.id.button22)
        var button23 = findViewById<Button>(R.id.button23)
        var button24 = findViewById<Button>(R.id.button24)
        var button25 = findViewById<Button>(R.id.button25)
        var button26 = findViewById<Button>(R.id.button26)
        var button27 = findViewById<Button>(R.id.button27)
        var button28 = findViewById<Button>(R.id.button28)

        var a = button1.getText()
        var b = button2.getText()
        var d = button19.getText()
        var e = button20.getText()
        var f = button21.getText()
        var g = button22.getText()
        var h = button23.getText()
        var i = button24.getText()
        var j = button25.getText()
        var k = button26.getText()
        var l = button27.getText()
        var m = button28.getText()


        button1.setOnClickListener {
            textEx.setText(a)
            button2.setOnClickListener {
                textEx.append(b)
                button19.setOnClickListener {
                    textEx.append(d)
                    button20.setOnClickListener{
                        textEx.append(e)
                        button21.setOnClickListener{
                            textEx.append(f)
                            button22.setOnClickListener{
                                textEx.append(g)
                                button23.setOnClickListener{
                                    textEx.append(h)
                                    button24.setOnClickListener{
                                        textEx.append(i)
                                        button25.setOnClickListener{
                                            textEx.append(j)
                                            button26.setOnClickListener{
                                                textEx.append(k)
                                                button27.setOnClickListener{
                                                    textEx.append(l)
                                                    button28.setOnClickListener{
                                                        textEx.append(m)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            }
                        }
                    }
                }
            }







    }

}