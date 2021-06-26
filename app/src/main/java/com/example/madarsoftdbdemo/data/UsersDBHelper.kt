package com.example.madarsoftdbdemo.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_AGE
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_GENDER
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_JOB_TITLE
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_NAME
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.TABLE_NAME
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry._ID

class UsersDBHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object{

        private const val DATABASE_NAME = "myUsers.db"
        private const val DATABASE_VERSION = 1
        private const val SQL_CREATE_USERS_TABLE = "CREATE TABLE $TABLE_NAME (" +
                "$_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_AGE INTEGER, " +
                "$COLUMN_JOB_TITLE TEXT, " +
                "$COLUMN_GENDER TEXT)"

        private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL(SQL_CREATE_USERS_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL(SQL_DELETE_ENTRIES)
    }


}