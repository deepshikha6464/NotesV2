package com.deeps.noteskotlinmvvmroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.deeps.noteskotlinmvvmroomdb.ViewModel.UserviewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:UserviewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(UserviewModel::class.java)
    }
}