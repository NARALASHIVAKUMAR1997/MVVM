package com.example.roomwithexoplayer.ui.main.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.loader.content.AsyncTaskLoader
import com.example.roomwithexoplayer.repositary.UserRepositary
import com.example.roomwithexoplayer.repositary.db.User
import kotlinx.coroutines.launch

class LoginViewModel(context: Context) : ViewModel() {

    private val arrayList = ArrayList<User>()
    private var userRepositary: UserRepositary

    init {
        sendDataToDB()
        userRepositary = UserRepositary.getInstance(context)
    }

    fun checkValidLogin(email: String, passWord: String): Boolean {
        return userRepositary.isValidAccount(email, passWord)
    }

    private fun sendDataToDB() {
        Thread(Runnable() {
            run {
                try {
                    userRepositary.insertAll()
                } catch (nullPointerException: NullPointerException) {
                    nullPointerException.printStackTrace()
                }
            }
        }).start()
    }
}