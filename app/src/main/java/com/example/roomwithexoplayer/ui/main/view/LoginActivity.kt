package com.example.roomwithexoplayer.ui.main.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.roomwithexoplayer.R
import com.example.roomwithexoplayer.ui.base.ViewModelFactory
import com.example.roomwithexoplayer.ui.main.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
    }

    override fun onResume() {
        super.onResume()
        performValidation()
    }

    private fun performValidation() {
        login.setOnClickListener {
            val userEmail = Login_email_input.text.toString()
            val userPassword = Login_password_input.text.toString()
            if (loginViewModel.checkValidLogin(userEmail, userPassword)) {
                val intent = Intent(
                    this,
                    HomeScreenActivity::class.java
                )
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid Email/Password", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setUpViewModel() {
        loginViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(this)
        ).get(LoginViewModel::class.java)

    }
}