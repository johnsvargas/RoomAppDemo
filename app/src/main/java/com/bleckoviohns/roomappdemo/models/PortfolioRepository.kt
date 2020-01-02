package com.bleckoviohns.roomappdemo.models

import androidx.lifecycle.MutableLiveData
import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.entities.UserDataResponse
import com.bleckoviohns.roomappdemo.models.Api.HttpCapptuApiAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PortfolioRepository (){

    private var userData = MutableLiveData<UserDataResponse>()

    fun getUserData() = userData

    fun getResposeUserData(idUser:Int,token:String){
        HttpCapptuApiAdapter.apiService.getUserData(token,idUser.toString()).enqueue(object:
            Callback<UserDataResponse> {
            override fun onFailure(call: Call<UserDataResponse>, t: Throwable) {
                TODO()
            }

            override fun onResponse(call: Call<UserDataResponse>, response: Response<UserDataResponse>) {
                if(response.isSuccessful){
                 userData.value = response.body()
                }
            }

        })
    }

}