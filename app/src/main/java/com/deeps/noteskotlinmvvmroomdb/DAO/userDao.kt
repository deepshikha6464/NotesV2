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
    fun insertUser(user:User)

//    get method
    @Query("SELECT * from user ORDER BY id ASC")
    fun getAllUserData():LiveData<List<User>>
}