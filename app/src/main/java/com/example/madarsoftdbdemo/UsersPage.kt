package com.example.madarsoftdbdemo

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_AGE
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_GENDER
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_JOB_TITLE
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.COLUMN_NAME
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry.TABLE_NAME
import com.example.madarsoftdbdemo.data.DatabaseManager.UserEntry._ID
import com.example.madarsoftdbdemo.data.User
import com.example.madarsoftdbdemo.data.UserDatabase
import com.example.madarsoftdbdemo.data.UsersDBHelper
import com.example.madarsoftdbdemo.databinding.ActivityUsersPageBinding

class UsersPage : AppCompatActivity() {

    private lateinit var binding: ActivityUsersPageBinding

    private lateinit var db: UserDatabase

    private lateinit var mDBhelper : UsersDBHelper

    private lateinit var linearLayoutManager : LinearLayoutManager
    private lateinit var adapter: UsersAdapter

    private var usersList : ArrayList<User> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUsersPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = UserDatabase.getInstance(this)

        Thread{
            displayUsers()
        }.start()






        //usersList.add(User("Nooreldin Elsayed", 24, "Android Developer", "Male"))



    }

    private fun displayUsers() {

        retrieveUsersfFromDB()

        addUsersToRecyclerView()


    }



    private fun retrieveUsersfFromDB() {

            usersList = db.userDao().readAllData() as ArrayList<User>



//        mDBhelper = UsersDBHelper(this)
//
//        val db = mDBhelper.readableDatabase
//
//        val projection = arrayOf(_ID, COLUMN_NAME, COLUMN_AGE, COLUMN_GENDER, COLUMN_JOB_TITLE)
//
//        val cursor : Cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)
//
//        val idColumnIndex = cursor.getColumnIndexOrThrow(_ID)
//        val nameColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_NAME)
//        val ageColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_AGE)
//        val jobTitleColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_JOB_TITLE)
//        val genderColumnIndex = cursor.getColumnIndexOrThrow(COLUMN_GENDER)
//
//        while (cursor.moveToNext()){
//
//            val currentId = cursor.getInt(idColumnIndex)
//            val currentName = cursor.getString(nameColumnIndex)
//            val currentAge = cursor.getInt(ageColumnIndex)
//            val currentJobTitle = cursor.getString(jobTitleColumnIndex)
//            val currentGender = cursor.getString(genderColumnIndex)
//
//            usersList.add(User(currentId, currentName, currentAge, currentJobTitle, currentGender))
//        }
//
//        cursor.close()

    }

    private fun addUsersToRecyclerView() {

            linearLayoutManager = LinearLayoutManager(this)
            binding.recyclerView.layoutManager= linearLayoutManager

            adapter = UsersAdapter(usersList)
            binding.recyclerView.adapter = adapter



    }

    override fun onStart() {
        super.onStart()
        usersList.clear()
        Thread{
            displayUsers()
        }.start()

    }

    fun addNewUser(view : View){

        val intent = Intent(this, NewUser::class.java)
        startActivity(intent)

    }

}