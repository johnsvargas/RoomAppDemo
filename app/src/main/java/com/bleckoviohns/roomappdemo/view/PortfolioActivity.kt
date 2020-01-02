package com.bleckoviohns.roomappdemo.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bleckoviohns.roomappdemo.R
import com.bleckoviohns.roomappdemo.databinding.ActivityPortfolioBinding
import com.bleckoviohns.roomappdemo.viewmodel.PortfolioViewModel

class PortfolioActivity : AppCompatActivity() {
    private var portfolioModelView : PortfolioViewModel? = null
    private var token =""
    private var idUser = 0
    private var context : Context = this
     companion object{
         const val ID_USER_DATA = "ID_USERDATA"
         const val TOKEN = "TOKEN"
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        intent.extras?.let {
            idUser = intent.getIntExtra(ID_USER_DATA,0)
            token = intent.getStringExtra(TOKEN)?:""
            setupBindings(savedInstanceState)

        }
    }

    fun setupBindings(savedInstanceState: Bundle?){
        var activityMainBinding:  ActivityPortfolioBinding= DataBindingUtil.setContentView(this, R.layout.activity_portfolio)
        portfolioModelView = ViewModelProviders.of(this).get(PortfolioViewModel::class.java)
        activityMainBinding.modelPotfolio = portfolioModelView
        getUserData()
    }

    fun getUserData(){
        portfolioModelView?.getReponseUserData(idUser,token)

        portfolioModelView?.getUserData()?.observe(this, Observer {
            Toast.makeText(context,"Peticion realizada con exito",Toast.LENGTH_LONG).show()
        })
    }
}
