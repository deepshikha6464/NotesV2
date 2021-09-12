package com.deeps.noteskotlinmvvmroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deeps.noteskotlinmvvmroomdb.Adapter.UserAdapter
import com.deeps.noteskotlinmvvmroomdb.Model.User
import com.deeps.noteskotlinmvvmroomdb.ViewModel.UserviewModel

class MainActivity : AppCompatActivity()
{

    lateinit var viewModel:UserviewModel
    private lateinit var builder:AlertDialog.Builder
    private lateinit var save: Button
    private lateinit var name:EditText
    private lateinit var age:EditText
    private lateinit var dialog:AlertDialog
    private lateinit var recyclerView:RecyclerView
    private lateinit var userAdapter:UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(UserviewModel::class.java)

        viewModel.getAllUser(applicationContext)?.observe(this, Observer {
            userAdapter.setData(it as ArrayList<User>)
        })
        val fab: View = findViewById(R.id.fab)
        recyclerView = findViewById(R.id.recyclerView)
        userAdapter = UserAdapter(this, ArrayList<User>())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=userAdapter
        }

        fab.setOnClickListener { view->
            openDialog()
        }
    }

    private fun openDialog() {
                builder=AlertDialog.Builder(this)
        val itemView:View = LayoutInflater.from(applicationContext).inflate(R.layout.dialogue,null)
        dialog=builder.create()
        dialog.setView(itemView)
        name=itemView.findViewById(R.id.name1)
        age=itemView.findViewById(R.id.age1)
        save=itemView.findViewById(R.id.save)
        save.setOnClickListener { view->

            saveDataIntoDB()
        }
        dialog.show()

    }

    private fun saveDataIntoDB()
    {
        val getname= name.text.toString().trim()
        val getage= age.text.toString().trim()

        if(!TextUtils.isEmpty(getname)&&!TextUtils.isEmpty(getage)) {
//            data insertion to room
            viewModel.insert(this,User(getname,Integer.parseInt(getage)))
            dialog.dismiss()

        } else{
                       Toast.makeText(applicationContext,"Please enter text",Toast.LENGTH_SHORT).show()
                       dialog.dismiss()
            }
    }




}