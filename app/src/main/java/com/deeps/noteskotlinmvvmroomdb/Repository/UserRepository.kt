package com.deeps.noteskotlinmvvmroomdb.Repository

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.deeps.noteskotlinmvvmroomdb.Database.UserDatabase
import com.deeps.noteskotlinmvvmroomdb.Database.UserDatabase.Companion.instance
import com.deeps.noteskotlinmvvmroomdb.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {
    private  val TAG = "UserRepository"
    companion object {
        private var DBinstance: UserDatabase? = null
        fun initializeDB(context: Context): UserDatabase? {
            return UserDatabase.getInstance(context)

        }

        fun insert(context: Context, user: User) {
            Log.d(TAG, "insert: ")
            DBinstance = initializeDB(context)
            CoroutineScope(IO).launch { DBinstance?.getDao()?.insertUser(user) }
        }

        fun getAllUserData(context:Context): LiveData<List<User>>? {
            DBinstance = initializeDB(context)

            return DBinstance?.getDao()?.getAllUserData()
        }
    }
}