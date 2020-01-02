package com.bleckoviohns.roomappdemo.models

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.bleckoviohns.roomappdemo.entities.ResponseUser

class LoginObservable: BaseObservable() {
    private var loginRepository = LoginRepository()

    fun getResponseLogin(): MutableLiveData<ResponseUser> {
        return loginRepository.getResponseLogin()
    }

    fun setLogin(user: String,password:String){
        loginRepository.setLogin(user, password)
    }
}