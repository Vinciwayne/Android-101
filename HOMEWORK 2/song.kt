

/*



Lollipop is the first single from American rapper Lil Wayne's sixth studio album, Tha Carter III.
The track posthumously features American singer Static Major and is produced by Deezle and Jim Jonsin.
It heavily utilizes the Auto-Tune vocal effect. The song was released digitally on March 13, 2008.



*/




 /*


in this kotlin code i used -
String
Int
Float


  */
package com.example.homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// it contains a string
        val artist: String =  "lil wayne, Static Major"
        Log.d("song", artist)



// this is a string
        val musicTitle: String = "lollipop"
        Log.d("song", musicTitle)



// this is an int
        val yearReleased: Int = 2008
        Log.d("song", yearReleased)


// this is an int
        var recorded:Int = 2007
        Log.d("song", recorded)



// the type of music
        val genre: String = "Electropop, R&B, dirty rap"
        Log.d("song", genre)


//the producers
        var producers:String = "Deezle, Jim Jonsin"
        Log.d("song", producers)


// the label involved
        var recordLabels:String = "Cash Money, Universal Motown"
        Log.d("song", recordLabels)


// the list of songwriters
        var songWriters:String = "Dwayne Carter, Stephen Garrett, Darius Harrison, Jim Jonsin, Rex Zamor, Marcus Cooper"
        Log.d("song", songWriters)

// this is a float
        var musicSales:Float = $10.7f

// this is string
        var note:string = "million"

        Log.d("song", musicSales)
        Log.d("song", note)

// this is a boolean
    var isLilwayneAMusician: boolean = true
        Log.d("song", isLilwayneAMusician)



    }
}
