package com.bleckoviohns.roomappdemo.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.entities.User
import com.bleckoviohns.roomappdemo.models.LoginObservable

class LoginViewModel() : ViewModel(){
    private var loginObservable = LoginObservable()
    private var userObserver =  MutableLiveData<ResponseUser>()

    fun getResponseLogin() : MutableLiveData<ResponseUser>{
        return loginObservable.getResponseLogin()
    }

    fun setLogin(user: String,password:String){
        loginObservable.setLogin(user,password)
    }
    fun getUser():MutableLiveData<ResponseUser>{
        return userObserver
    }
    fun setOnClickBtnLogin(email:String?,password: String?){
        var user = ResponseUser()
        user.email = email
        user.pass = password?:""
        Log.e("Errororororororo","Aqui llego 1")
        userObserver.value = user
    }
}