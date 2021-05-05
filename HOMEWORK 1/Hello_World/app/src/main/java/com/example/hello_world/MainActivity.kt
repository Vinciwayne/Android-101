package com.example.hello_world

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // this fins the button that will be used for clicks
        val  submitButton = findViewById<Button>(R.id.submit_button)

        //this goes to find where the text will be displayed
        val dispMessage = findViewById<TextView>(R.id.text1)

        // tell the button to listen for clicks and execute what is inside the curly bracket
        submitButton.setOnClickListener {

            // this  displays the message as a TextView
            dispMessage.setText("hello world!")

        }


    }





}

// EZEBUIRO UCHECHUKWU VINCENT