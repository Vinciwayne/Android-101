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



        // call database functions in the appropriate locations // fetch function
        val dbo = DatabaseOpertions(this)
        val cursor = dbo.getAllItems(dbo)
        with(cursor) {
            while (moveToNext()) {
                val itemName = getString(getColumnIndex(DatabaseInfo.TableInfo.COLUMN_ITEM_NAME))

                val itemUrgency = getInt(getColumnIndex(DatabaseInfo.TableInfo.COLUMN_ITEM_URGENCY))
                val isUrgent = if (itemUrgency == 0) false else true

                val itemDate = getString(getColumnIndex(DatabaseInfo.TableInfo.COLUMN_DATE))

                todoItemsList.add(TodoItem(itemName, isUrgent))
            }
        }


//        todoItemsList.add(TodoItem("Buy food", true))
//        todoItemsList.add(TodoItem("Go to the airport"))
//        todoItemsList.add(TodoItem("learn kotlin", false))


        todoItemRecyclerView = findViewById(R.id.todo_item_recycler_view)

        recyclerLayoutManager = LinearLayoutManager(this)

        recyclerAdapter = TodoItemsAdapter(todoItemsList, this)



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