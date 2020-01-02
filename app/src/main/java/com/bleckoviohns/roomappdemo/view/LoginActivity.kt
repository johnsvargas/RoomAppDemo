package com.bleckoviohns.roomappdemo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bleckoviohns.roomappdemo.R
import com.bleckoviohns.roomappdemo.databinding.ActivityLoginBinding
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private var loginViewModel: LoginViewModel? = null
    private var context = this
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
                loginViewModel?.setLogin(user.email?:"",user.pass?:"")
                getLogin()
            })
    }

    fun getLogin(){
        loginViewModel?.getResponseLogin()?.observe(this,
            Observer {responseUser: ResponseUser ->
                Toast.makeText(context,"Ingreso: ${responseUser.first_name}",Toast.LENGTH_LONG).show()
                var intentPortfolioActivity  = Intent(context,PortfolioActivity::class.java)
                intentPortfolioActivity.putExtra(PortfolioActivity.ID_USER_DATA,responseUser.id)
                intentPortfolioActivity.putExtra(PortfolioActivity.TOKEN,"token ${responseUser.token}")
                startActivity(intentPortfolioActivity)
            })
    }
}
