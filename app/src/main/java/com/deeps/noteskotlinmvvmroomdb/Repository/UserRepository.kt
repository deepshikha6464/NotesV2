package com.deeps.noteskotlinmvvmroomdb.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.deeps.noteskotlinmvvmroomdb.Database.UserDatabase
import com.deeps.noteskotlinmvvmroomdb.Database.UserDatabase.Companion.instance
import com.deeps.noteskotlinmvvmroomdb.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository {

    companion object {
        private var DBinstance: UserDatabase? = null
        fun initializeDB(context: Context): UserDatabase? {
            return UserDatabase.getInstance(context)

        }

        fun insert(context: Context, user: User) {
            DBinstance = initializeDB(context)
            CoroutineScope(IO).launch { DBinstance?.getDao()?.insertUser(user) }
        }

        fun getAllUserData(context:Context): LiveData<List<User>>? {
            DBinstance = initializeDB(context)

            return DBinstance?.getDao()?.getAllUserData()
        }
    }
}