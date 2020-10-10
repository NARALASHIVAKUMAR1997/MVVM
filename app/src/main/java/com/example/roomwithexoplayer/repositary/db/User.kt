package com.example.roomwithexoplayer.repositary.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "email")
    var userEmail: String,

    @ColumnInfo(name = "password")
    var userPassword: String
)