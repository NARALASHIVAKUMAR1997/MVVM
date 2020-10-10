package com.example.roomwithexoplayer.repositary.db

import android.content.Context
import androidx.room.Room

object DataBaseBuilder {

    private var userDataBase: UserDataBase? = null

   fun getUserDataBase(context: Context): UserDataBase? {
        if (userDataBase == null) {
            synchronized(UserDataBase::class) {
                userDataBase = buildRoomDb(context)
            }
        }
        return userDataBase!!
    }

    private fun buildRoomDb(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            UserDataBase::class.java,
            "user_database"
        ).allowMainThreadQueries().build()
}