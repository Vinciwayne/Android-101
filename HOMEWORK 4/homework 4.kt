package com.example.homework_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main

    }




    fun pressButtonAction(view: View) {
        for (number in 1..100){
            if (number % 15 == 0) {
                println("FizzBuzz")}
            else if(number % 5 == 0) {
                println("Buzz")}
            else if(number % 3 == 0){
                println("Fizz")}
            else if(number % number == 0 && number % 1 == 0){
                println("prime")}
            else {
                println(number)
            }

        }
Log.d("MainActivity","my fizzbuzz test")
    }




}



// VINCENT U. EZEBUIRO


