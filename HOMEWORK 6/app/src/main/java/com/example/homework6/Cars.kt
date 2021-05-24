package com.example.homework6

class Cars(name:String, model:String, year:Int, weight:Int):Vehicle(name, model,year, weight) {
    var isDriving = false

    fun drive() { isDriving = true }

    fun stop() {
            isDriving = false
            needsMaintenance = ++ tripsSinceMaintenance > maxTrips

    }

    override fun toString(): String {
        return super.toString() +  " |  Cars(isDriving=$isDriving)"
    }
}

// VINCENT U. EZEBUIRO