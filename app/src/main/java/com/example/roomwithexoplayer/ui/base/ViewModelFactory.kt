package com.example.roomwithexoplayer.ui.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomwithexoplayer.ui.main.viewModel.HomeDataViewModel
import com.example.roomwithexoplayer.ui.main.viewModel.LoginViewModel

class ViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(context) as T
            }
            modelClass.isAssignableFrom(HomeDataViewModel::class.java) -> {
                HomeDataViewModel() as T
            }
            else -> {
                throw IllegalArgumentException("Unknown class name")
            }
        }
    }
}