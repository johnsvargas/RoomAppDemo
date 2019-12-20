package com.bleckoviohns.roomappdemo.models

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.entities.User

class LoginObservable: BaseObservable() {
    private var loginRepository = LoginRespository()

    fun getResponseLogin(): MutableLiveData<ResponseUser> {
        return loginRepository.getResponseLogin()
    }

    fun setLogin(user: String,password:String){
        loginRepository.setLogin(user, password)
    }
}