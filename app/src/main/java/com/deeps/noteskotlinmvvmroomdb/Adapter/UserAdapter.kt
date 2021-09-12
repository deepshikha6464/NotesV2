package com.deeps.noteskotlinmvvmroomdb.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deeps.noteskotlinmvvmroomdb.Model.User
import com.deeps.noteskotlinmvvmroomdb.R

class UserAdapter(private val context: Context,private var userList:ArrayList<User>): RecyclerView.Adapter<UserAdapter.userViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
 return userViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
          val user:User=userList[position]
          holder.name.text = user.name
          holder.age.text = user.age.toString()

    }

    override fun getItemCount(): Int = userList.size


fun setData(userList:ArrayList<User>){
    this.userList=userList
    notifyDataSetChanged()
}
    inner class userViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        val name:TextView=itemView.findViewById(R.id.name)
        val age:TextView=itemView.findViewById(R.id.age)
    }
}