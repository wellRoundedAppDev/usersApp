package com.example.madarsoftdbdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madarsoftdbdemo.data.User

class UsersAdapter(private var usersList : MutableList<User>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): UsersAdapter.UsersViewHolder {

        val context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val shouldAttachToParentImmediately = false

        val view = inflater.inflate(R.layout.recycler_user_item, viewGroup, shouldAttachToParentImmediately)

        return UsersViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsersAdapter.UsersViewHolder, position: Int) {

        val item = usersList[position]
        holder.bindUser(item)
    }

    override fun getItemCount(): Int {

        return usersList.size
    }

    class UsersViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{


        private var view : View
        private lateinit var user : User
        private var name : TextView
        private var age: TextView
        private var jobTitle: TextView
        private var gender: TextView




        override fun onClick(v: View?) {

            return
        }

        init{

            view = v

            name = view.findViewById(R.id.name_value_recycler_item)
            age = view.findViewById(R.id.age_value_recycler_item)
            jobTitle = view.findViewById(R.id.job_title_value_recycler_item)
            gender = view.findViewById(R.id.gender_value_recycler_item)

            v.setOnClickListener(this)
        }

        fun bindUser(user : User){

            this.user = user

            name.text = user.name
            age.text = user.age.toString()
            jobTitle.text = user.jobTitle
            gender.text = user.gender

        }

    }
}