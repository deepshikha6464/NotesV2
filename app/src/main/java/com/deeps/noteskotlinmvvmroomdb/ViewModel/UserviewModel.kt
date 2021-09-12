package com.deeps.noteskotlinmvvmroomdb.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.deeps.noteskotlinmvvmroomdb.Model.User
import com.deeps.noteskotlinmvvmroomdb.Repository.UserRepository

class UserviewModel: ViewModel() {

    fun insert(context:Context , user: User){
        UserRepository.insert(context,user)
    }

    fun getAllUser(context:Context): LiveData<List<User>>? {
        return UserRepository.getAllUserData(context)
    }
}