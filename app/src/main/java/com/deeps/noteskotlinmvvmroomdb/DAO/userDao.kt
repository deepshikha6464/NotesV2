package com.deeps.noteskotlinmvvmroomdb.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.deeps.noteskotlinmvvmroomdb.Model.User

@Dao
 interface userDao {

//    insert method decleration
    @Insert( onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertUser(user:User) {

     }             // suspend as we are working with courtitens by which insert will work in background thread

//    get method
    @Query("SELECT * from user ORDER BY id ASC")
    fun getAllUserData():LiveData<List<User>>
}