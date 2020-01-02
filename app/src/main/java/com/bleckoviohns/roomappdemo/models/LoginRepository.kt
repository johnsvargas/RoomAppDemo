package com.bleckoviohns.roomappdemo.models

import androidx.lifecycle.MutableLiveData
import com.bleckoviohns.roomappdemo.entities.ErrorsAppCapptu
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.models.Api.HttpCapptuApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
    private var responseLogin = MutableLiveData<ResponseUser>()
    private var errorMessage = MutableLiveData<ErrorsAppCapptu>()

    fun getResponseLogin():MutableLiveData<ResponseUser> {
        return responseLogin
    }

    fun setLogin(user: String,password:String){
        HttpCapptuApiAdapter.apiService.postLogin(user
            ,password,1,"","").enqueue(object: Callback<ResponseUser>{
            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                //errorMessage.value = GsonConverterFactory()
            }

            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if(response.isSuccessful){
                    responseLogin.value = response.body()
                }
            }

        })
    }
}