package com.example.homework6

// creating class
open class Vehicle(val make:String, val model:String, val year:Int, val weight:Int){

    var needsMaintenance:Boolean = false
    var tripsSinceMaintenance: Int = 0
    val maxTrips:Int = 100

    open fun repair() {
        needsMaintenance = false
        tripsSinceMaintenance = 0
    }

    override fun toString(): String {
        return "Vehicle(make='$make', model='$model', year=$year, weight=$weight, needsMaintenance=$needsMaintenance, tripsSinceMaintenance=$tripsSinceMaintenance)"
    }




}

// VINCENT U. EZEBUIRO