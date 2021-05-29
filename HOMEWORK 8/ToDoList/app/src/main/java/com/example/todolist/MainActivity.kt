package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    private lateinit var todoItemRecyclerView: RecyclerView

    private lateinit var recyclerAdapter: TodoItemsAdapter

    private lateinit var recyclerLayoutManager: RecyclerView.LayoutManager

    var todoItemsList = ArrayList<TodoItem>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        todoItemsList.add(TodoItem("Buy food"))
        todoItemsList.add(TodoItem("Go to the airport", true))
        todoItemsList.add(TodoItem("learn kotlin", false))


        todoItemRecyclerView = findViewById(R.id.todo_item_recycler_view)

        recyclerLayoutManager = LinearLayoutManager(this)

        recyclerAdapter = TodoItemsAdapter(todoItemsList)



        todoItemRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = recyclerLayoutManager
            adapter = recyclerAdapter
        }

    }



    public fun navToAddItemAction(view: View){
        // showing intent and add the page you want to navigate to 
        val intent:Intent = Intent(this, AdditemActivity::class.java)
        // to start the activity
        startActivity(intent)

    }



}