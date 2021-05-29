package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var todoItemRecyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        todoItemRecyclerView = findViewById(R.id.todo_item_recycler_view)

    }



    public fun navToAddItemAction(view: View){
        // showing intent and add the page you want to navigate to 
        val intent:Intent = Intent(this, AdditemActivity::class.java)
        // to start the activity
        startActivity(intent)

    }



}