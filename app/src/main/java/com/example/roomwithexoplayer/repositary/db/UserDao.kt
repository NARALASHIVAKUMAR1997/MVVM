package com.example.roomwithexoplayer.repositary.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun insertAll(user: List<User>)

    @Query("select * from user where user.email LIKE :useremail")
   fun getEmailAndPassWord(useremail:String): User

}