package com.example.homework6

import android.util.Log

class Planes(name:String, model:String, year:Int, weight:Int):Vehicle(name,model,year, weight) {
    var isFlying = false


    fun flying(): Boolean {
        if (needsMaintenance) Log.e("PLANE", "The plane can't fly until it has been repaired.") else isFlying = true
        return  isFlying
    }

    fun landing(){
        if (isFlying)  {
            isFlying = false
            needsMaintenance =  tripsSinceMaintenance++ > maxTrips
        }
    }

    override fun toString(): String {
        return super.toString() + " | Planes(isFlying=$isFlying)"
    }


}

// VINCENT U. EZEBUIRO