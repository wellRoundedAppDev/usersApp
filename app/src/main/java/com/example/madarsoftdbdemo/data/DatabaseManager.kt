package com.example.madarsoftdbdemo.data

import android.provider.BaseColumns

object DatabaseManager {

    object UserEntry : BaseColumns{

        const val TABLE_NAME = "users"

        const val _ID = BaseColumns._ID

        const val COLUMN_NAME = "name"
        const val COLUMN_AGE = "age"
        const val COLUMN_JOB_TITLE = "job_title"
        const val COLUMN_GENDER = "gender"



    }
}