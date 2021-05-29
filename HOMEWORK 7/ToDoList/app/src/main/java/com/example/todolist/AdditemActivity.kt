package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText

class AdditemActivity : AppCompatActivity() {


    private lateinit var itemNameEditText: EditText

    private lateinit var isUrgentCheckBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)



        itemNameEditText = findViewById(R.id.editTextTextPersonName)

        isUrgentCheckBox = findViewById(R.id.checkBox)


    }

    public fun toSaveItem(view: View) {

    }



    public fun toGoBackToHome(view: View) {
        // showing intent and add the page you want to navigate to
        val intent: Intent = Intent(this, MainActivity::class.java)
        // to start the activity
        startActivity(intent)
    }
}