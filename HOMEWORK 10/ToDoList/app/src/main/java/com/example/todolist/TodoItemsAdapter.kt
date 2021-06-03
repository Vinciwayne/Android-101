package com.example.todolist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView


// this is a layout adapter
class TodoItemsAdapter(private val todoItemsList: ArrayList<TodoItem>,  val activity: MainActivity):
    RecyclerView.Adapter<TodoItemsAdapter.ViewHolder>() {




    class ViewHolder(val constraintLayout: ConstraintLayout): RecyclerView.ViewHolder(constraintLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val constraintLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.to_do_item_layout, parent, false) as ConstraintLayout




        // onClick listener
        // take you to edit item page
        constraintLayout.setOnClickListener(View.OnClickListener {
            val nameTextView = constraintLayout.getChildAt(0) as TextView
            val urgencyTextView = constraintLayout.getChildAt(1) as TextView
            val nameText = nameTextView.text
            val urgencyText = urgencyTextView.text
            val isItemUrgent = if (urgencyText == "!!") true else false

            // showing intent and add the page you want to navigate to
            val intent: Intent = Intent(parent.context, AdditemActivity::class.java)
            intent.putExtra("ITEM_NAME", nameText)
            intent.putExtra("ITEM_URGENCY",isItemUrgent)
            // to start the activity
            activity.startActivity(intent)
        })





        //  onLongClick Listener  // for option  // here is to delete
        constraintLayout.setOnLongClickListener(View.OnLongClickListener {
            val position:Int = parent.indexOfChild(it)

            // delete function
            val todoItemToRemove = activity.todoItemsList[position]
            val dbo = DatabaseOpertions(parent.context)
            dbo.deleteItem(dbo, todoItemToRemove)

            activity.todoItemsList.removeAt(position)
            notifyItemRemoved(position)
            true

        })






        return ViewHolder(constraintLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val constraintLayout = holder.constraintLayout
        val nameTextView = constraintLayout.getChildAt(0) as TextView
        val urgencyTextView = constraintLayout.getChildAt(1) as TextView
        nameTextView.text = todoItemsList[position].name
        urgencyTextView.text = if (todoItemsList[position].isUrgent) "!!" else ""
    }

    override fun getItemCount(): Int {
        return todoItemsList.size
    }
}