package com.example.todolist

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


class DatabaseOpertions(context:Context):SQLiteOpenHelper(
        context, DATABASE_NAME, null, DATABASE_VERSION )  {


    companion object {
        // If you change the database schema, you must increment the database version.
        const val  DATABASE_NAME = "TodoItems.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(DatabaseInfo.SQL_CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DatabaseInfo.SQL_DELETE_TABLE_QUERY)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }



    // add, fetch, modify/update, delete

        // ---------------add function------------------
    fun addItem(dbo: DatabaseOpertions, todoItem: TodoItem){

            // Gets the data repository in write mode
        val db =  dbo.writableDatabase
        val itemName = todoItem.name
        val isItemUrgent = todoItem.isUrgent
        val itemUrgency = if (isItemUrgent) 1 else 0
        val itemDate = todoItem.getDateAsString()

            // Create a new map of values, where column names are the keys
        val contentValues = ContentValues().apply {
            put(DatabaseInfo.TableInfo.COLUMN_ITEM_NAME, itemName)
            put(DatabaseInfo.TableInfo.COLUMN_ITEM_URGENCY, itemUrgency)
            put(DatabaseInfo.TableInfo.COLUMN_DATE, itemDate)
        }
        // Insert the new row, returning the primary key value of the new row
        val rowID = db.insert(DatabaseInfo.TableInfo.TABLE_NAME, null, contentValues)
    }

    //------------ add function ends--------------




    //--------------------- fetch function------------------

    fun getAllItems(dbo: DatabaseOpertions): Cursor{
        val db = dbo.readableDatabase
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection = arrayOf(
                BaseColumns._ID,
                DatabaseInfo.TableInfo.COLUMN_ITEM_NAME,
                DatabaseInfo.TableInfo.COLUMN_ITEM_URGENCY,
                DatabaseInfo.TableInfo.COLUMN_DATE )

        // Filter results WHERE
        val selection = ""
        val selectionArgs = null
        // How you want the results sorted in the resulting Cursor
        val sortOrder = null

        // The table to query
        val cursor = db.query(
                DatabaseInfo.TableInfo.TABLE_NAME,           // The array of columns to return (pass null to get all)
                projection,                 // The columns for the WHERE clause
                selection,                  // The values for the WHERE clause
                selectionArgs,            // don't group the rows
                null,           // don't filter by row groups
                null,           // don't filter by row groups
                sortOrder               // The sort order
        )
        return cursor

    }
    //--------------------- fetch function ends------------------







    //----------------------------- modify/update function-----------------------

    fun updateItem(dbo: DatabaseOpertions, oldItem: TodoItem, newItem: TodoItem){

        val db =  dbo.writableDatabase
        val itemName = newItem.name
        val isItemUrgent = newItem.isUrgent
        val itemUrgency = if (isItemUrgent) 1 else 0
        val itemDate = newItem.getDateAsString()


        val contentValues = ContentValues().apply {
            put(DatabaseInfo.TableInfo.COLUMN_ITEM_NAME, itemName)
            put(DatabaseInfo.TableInfo.COLUMN_ITEM_URGENCY, itemUrgency)
            put(DatabaseInfo.TableInfo.COLUMN_DATE, itemDate)
        }

                // Which row to update, based on the name
            val selection = "${DatabaseInfo.TableInfo.COLUMN_ITEM_NAME} LIKE ?"
            val selectionArgs = arrayOf(oldItem.name)


            db.update(DatabaseInfo.TableInfo.TABLE_NAME, contentValues, selection, selectionArgs)
    }


//----------------------------- modify/update function ends-----------------------





    // -------------------------------------delete function----------------------------

    fun deleteItem(dbo: DatabaseOpertions, todoItem: TodoItem){
        val db = dbo.writableDatabase

        // Define 'where' part of query.
        val selection = "${DatabaseInfo.TableInfo.COLUMN_ITEM_NAME} LIKE ?"

        // Specify arguments in placeholder order.
        val selectionArgs = arrayOf(todoItem.name)

        // Issue SQL statement.
        val deletedRows = db.delete(DatabaseInfo.TableInfo.TABLE_NAME, selection, selectionArgs)

    }

    // -------------------------------------delete function ends----------------------------


}