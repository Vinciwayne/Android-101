package com.example.homework6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }


    fun useVehicles(view:View) {

        //creating three instances from Cars class
        val mustang :Cars = Cars("mustang", "g45", 2009, 1300)
        val toyota :Cars = Cars("toyota", "corolla", 2004, 1380)
        val jeep :Cars = Cars("jeep", "67t", 2010, 1400)
        //creating two instances from Plane class
        val planeOne : Planes = Planes("Aeronca","15 AC Sedan", 1992, 2050)
        val planeTwo : Planes = Planes("Aeronca","12 AC Sedan", 1982, 2030)

        // CARS
        Log.i("TOYOTA", toyota.toString())
        repeat(110) {
           mustang.drive()
            mustang.stop()
        }

        Log.i("MUSTANG", mustang.toString())
        mustang.repair()
        Log.i("MUSTANG", mustang.toString())
        repeat(10) {
            jeep.drive()
            jeep.stop()
        }

        Log.i("JEEP", mustang.toString())
        repeat(125) {
            planeOne.flying()
            planeOne.landing()
        }

        // PLANES
        Log.i("AERONCA", planeOne.toString())



        Log.i("AERONCA", planeTwo.toString())



    }

}


// VINCENT U. EZEBUIRO