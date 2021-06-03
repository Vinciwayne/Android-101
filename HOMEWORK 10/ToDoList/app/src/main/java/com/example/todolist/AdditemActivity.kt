package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class AdditemActivity : AppCompatActivity() {


    private lateinit var itemNameEditText: EditText

    private lateinit var isUrgentCheckBox: CheckBox

    private lateinit var titleTextView:TextView


    private var isNewItem = true
    private lateinit var oldItem: TodoItem



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)


        itemNameEditText = findViewById(R.id.editTextTextPersonName)
        isUrgentCheckBox = findViewById(R.id.urgent_checkBox)
        titleTextView = findViewById(R.id.title_text_view)



        val itemName = intent.getStringExtra("ITEM_NAME")
        val itemUrgency= intent.getBooleanExtra("ITEM_URGENCY", false)



        // when there's something to change in addItem layout
        if(itemName != null){
            itemNameEditText.setText(itemName)
            titleTextView.setText(R.string.edit_item_message)

            oldItem = TodoItem(itemName)
            isNewItem = false
        }
        if (itemUrgency){
            isUrgentCheckBox.isChecked = true

            oldItem.isUrgent = itemUrgency
        }


    }

    public fun toSaveItem(view: View) {
        val itemName = itemNameEditText.text.toString()
        val isItemUrgent = isUrgentCheckBox.isChecked
        val newTodoItem = TodoItem(itemName,isItemUrgent)

        val dbo = DatabaseOpertions(this)
        if (isNewItem){
            dbo.addItem(dbo, newTodoItem)
        } else {
            dbo.updateItem(dbo, this.oldItem, newTodoItem)
        }

        // showing intent and add the page you want to navigate to
        val intent: Intent = Intent(this, MainActivity::class.java)
        // to start the activity
        startActivity(intent)

    }



    public fun toGoBackToHome(view: View) {
        // showing intent and add the page you want to navigate to
        val intent: Intent = Intent(this, MainActivity::class.java)
        // to start the activity
        startActivity(intent)
    }
}