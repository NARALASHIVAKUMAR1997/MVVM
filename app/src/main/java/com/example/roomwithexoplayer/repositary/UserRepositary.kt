package com.example.roomwithexoplayer.repositary

import android.content.Context
import android.text.TextUtils
import com.example.roomwithexoplayer.repositary.db.DataBaseBuilder.getUserDataBase
import com.example.roomwithexoplayer.repositary.db.User
import com.example.roomwithexoplayer.repositary.db.UserDao
import kotlin.NullPointerException

class UserRepositary(context: Context) {

    private var userDao: UserDao = getUserDataBase(context)!!.userDao()
    var isSuccessFul = false

    fun isValidAccount(email: String, password: String): Boolean {
        val user = userDao.getEmailAndPassWord(email)
        if (user!= null && password!= null){
            return TextUtils.equals(user.userPassword, password)
        }else{
            return false
        }
    }

    fun insertAll() {
        val arrayList = ArrayList<User>()
        arrayList.add(User("sample@gmail.com", "sample@123"))
        arrayList.add(User("test@gmail.com", "Test@987"))
        arrayList.add(User("dummy@gmail.com", "DuMMY@345"))
        userDao.insertAll(arrayList)
    }

    companion object {
        private var instance: UserRepositary? = null
        fun getInstance(context: Context): UserRepositary {
            if (instance == null) {
                instance = UserRepositary(context)
            }
            return instance!!
        }
    }
}