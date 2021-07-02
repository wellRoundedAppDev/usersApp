package com.example.madarsoftdbdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.madarsoftdbdemo.data.User
import com.example.madarsoftdbdemo.data.UserDatabase
import com.example.madarsoftdbdemo.data.UserViewModel
import com.example.madarsoftdbdemo.databinding.ActivityUsersPageBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UsersPage : AppCompatActivity() {

    private lateinit var binding: ActivityUsersPageBinding

    private lateinit var mUserViewModel: UserViewModel

    //private lateinit var db: UserDatabase

    //private lateinit var mDBhelper : UsersDBHelper

    private lateinit var linearLayoutManager : LinearLayoutManager
    private lateinit var adapter: UsersAdapter

    private var usersList : ArrayList<User> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityUsersPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //db = UserDatabase.getInstance(this)

        displayUsers()







        //usersList.add(User("Nooreldin Elsayed", 24, "Android Developer", "Male"))



    }

    private fun displayUsers() {


        addUsersToRecyclerView()

        retrieveUsersfFromDB()




    }



    private fun retrieveUsersfFromDB() {

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(this, Observer { user ->

            adapter.setData(user)

        })




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


        adapter = UsersAdapter()
        binding.recyclerView.adapter = adapter

        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = linearLayoutManager


    }

//    override fun onStart() {
//        super.onStart()
//        displayUsers()
//    }

    fun addNewUser(view : View){

        val intent = Intent(this, NewUser::class.java)
        startActivity(intent)
    }

}