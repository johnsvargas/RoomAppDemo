package com.bleckoviohns.roomappdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bleckoviohns.roomappdemo.R
import com.bleckoviohns.roomappdemo.databinding.ActivityLoginBinding
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?){
        var activityMainBinding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        activityMainBinding.model = loginViewModel
        setLogin()
    }

    fun setLogin() {
        loginViewModel?.getUser()?.observe(this,
            Observer {user: ResponseUser ->
                loginViewModel?.setLogin(user.email?:"",user.pass)
            })
    }
}
