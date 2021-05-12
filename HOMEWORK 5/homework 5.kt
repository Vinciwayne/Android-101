package com.example.homework_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        genre()
        artist()
        year()


    }

// genre
    fun genre(): String {
        return "Electropop, R&B, dirty rap"
    }


// names of artist
    fun artist(): String{
        return "lil wayne, Static Major"
    }


// year
    fun year(): Int {
    return 2007
    }




// VINCENT U. EZEBUIRO