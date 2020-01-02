package com.bleckoviohns.roomappdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.models.LoginObservable

class LoginViewModel : ViewModel(){
    private var loginObservable = LoginObservable()
    private var userObserver =  MutableLiveData<ResponseUser>()


    var password: MutableLiveData<String> =  MutableLiveData<String>()
    var email: MutableLiveData<String> =  MutableLiveData<String>()

    fun getResponseLogin() : MutableLiveData<ResponseUser>{
        return loginObservable.getResponseLogin()
    }

    fun setLogin(user: String,password:String){
        loginObservable.setLogin(user,password)
    }
    fun getUser():MutableLiveData<ResponseUser>{
        return userObserver
    }
    fun setOnClickBtnLogin(){
        userObserver.value = ResponseUser(email.value?:"", password.value?:"")
    }
}