package com.bleckoviohns.roomappdemo.models

import androidx.lifecycle.MutableLiveData
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.entities.User
import com.bleckoviohns.roomappdemo.models.Api.HttpCapptuApiAdapter
import com.bleckoviohns.roomappdemo.models.Api.HttpCapptuApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRespository {
    private var responseLogin = MutableLiveData<ResponseUser>()

    fun getResponseLogin():MutableLiveData<ResponseUser> {
        return responseLogin
    }

    fun setLogin(user: String,password:String){
        HttpCapptuApiAdapter.apiService.PostLogin(user
            ,password,1,"","").enqueue(object: Callback<ResponseUser>{
            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {

            }

            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if(response.isSuccessful){
                    responseLogin.value = response.body()
                }
            }

        })
    }
}