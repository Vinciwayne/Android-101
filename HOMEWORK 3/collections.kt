package com.example.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class collections : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


/*
Array is mutable (it can be changed through any reference to it), but List doesn't
 have modifying methods (it is either read-only view of Mutable List or an immutable
 list implementation). Arrays have fixed size and cannot expand or shrink retaining identity
 (you need to copy an array to resize it)
 */


// extra credit
/*
 mutable reads, write operations: adding, removing, and updating its elements.
 */







        //non-mutable

        val names1 = listOf<String>("Joe","Ben","Thomas")
        names1.get(2)
        names1[2]
        


        val names2 = arrayOf<String>("Joe","Ben","Thomas")
        names2.get(3)
        names2.size
        names2[3]
        names2.set(4, "Butler")


        //mutable

        val names6 = mutableListOf<String>("orange", "pawpaw", "grape", "cherry", "banana")
        names6.add(4, "guava")
        names6.remove("pawpaw")
        names6.get(4)



        val names5 = arrayListOf<String>("Joe","Ben","Thomas")
        names5.get(1)
        names5.add(5, "Benson")
        names5.remove("Ben")
        names5.trimToSize()










    }
}


// VINCENT U. EZEBUIRO