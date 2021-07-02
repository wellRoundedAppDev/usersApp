package com.example.madarsoftdbdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.madarsoftdbdemo.data.User
import com.example.madarsoftdbdemo.data.UserDatabase
import com.example.madarsoftdbdemo.data.UserViewModel
import com.example.madarsoftdbdemo.databinding.ActivityNewUserBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewUser : AppCompatActivity() {

    private lateinit var binding: ActivityNewUserBinding

    //private lateinit var db: UserDatabase

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityNewUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        //db = UserDatabase.getInstance(this)

        binding.saveUserButton.setOnClickListener {

                insertUser()

        }

        binding.displayUsersButton.setOnClickListener {

            transitionToUssersPage()
        }



    }

    private fun insertUser(){

        if(editTextFieldsAreEmpty()){

            Toast.makeText(this, "Fill All fields!!", Toast.LENGTH_LONG).show()
            return
        }

        val name = binding.nameEditTextView.text.toString().trim(){it <= ' '}
        val age = binding.ageEditTextView.text.toString().trim(){it <= ' '}
        val jobTitle = binding.jobTitleEditTextView.text.toString().trim(){it <= ' '}
        val gender = binding.genderEditTextView.text.toString().trim(){it <= ' '}

        mUserViewModel.addUser(User(0, name, age.toInt(), jobTitle, gender))
        Toast.makeText(this, "New user added", Toast.LENGTH_SHORT).show()









//        val mDBHelper = UsersDBHelper(this)
//
//        val db = mDBHelper.writableDatabase
//
//        val values = ContentValues().apply{
//
//            put(COLUMN_NAME, name)
//            put(COLUMN_AGE, age.toInt())
//            put(COLUMN_JOB_TITLE, jobTitle)
//            put(COLUMN_GENDER, gender)
//        }
//
//        val rowId = db.insert(TABLE_NAME, null, values)//insert new row and returns id of inserted row
//
//        if(rowId.equals(-1)){
//
//            Toast.makeText(this, "problem inserting new user", Toast.LENGTH_SHORT).show()
//        }
//        else{
//
//            Toast.makeText(this, "user inserted into DB with id: $rowId", Toast.LENGTH_SHORT).show()
//        }

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.action_bar_menu, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        return when(item.itemId){
//
//            R.id.save_user -> {
//
//                Thread{
//                    insertUser()
//                }.start()
//
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//
//        }
//    }

    private fun transitionToUssersPage(){

        val intent = Intent(this, UsersPage::class.java)
        startActivity(intent)

    }

    private fun editTextFieldsAreEmpty(): Boolean {

        if(binding.nameEditTextView.text.isEmpty() || binding.ageEditTextView.text.isEmpty() || binding.jobTitleEditTextView.text.isEmpty() || binding.genderEditTextView.text.isEmpty()){

            return true
        }
        else
            return false


    }


}
