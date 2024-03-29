package com.deeps.noteskotlinmvvmroomdb.Database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deeps.noteskotlinmvvmroomdb.DAO.userDao
import com.deeps.noteskotlinmvvmroomdb.Model.User
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class],version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {


    abstract  fun getDao():userDao            //will call all the function of dao interface in repository

    companion object {
        private const val DATABASE_NAME = "UserDatabase"
        @Volatile
        var instance:UserDatabase ?=null
        fun getInstance(context: Context):UserDatabase?
        {
            if(instance==null)
            {
                 kotlin.synchronized(UserDatabase::class.java)
                 {
                    if(instance== null)
                    {
                        instance = Room.databaseBuilder(context,UserDatabase::class.java,
                            DATABASE_NAME).build()
                    }
                }
            }
            return instance
        }
    }
}