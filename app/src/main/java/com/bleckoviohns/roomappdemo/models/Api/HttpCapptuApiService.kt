package com.bleckoviohns.roomappdemo.models.Api


import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.entities.UserDataResponse
import retrofit2.Call
import retrofit2.http.*

interface HttpCapptuApiService {
    @FormUrlEncoded
    @POST("login/")
    fun postLogin(@Field("email") email: String, @Field("password") password: String, @Field("version") version: Int,
                  @Field("ios_token") ios_token: String, @Field("android_token") android_token: String): Call<ResponseUser>

    //region User
    @GET("users/{idUser}/")
    fun getUserData(@Header("Authorization") token: String, @Path("idUser") idUser: String): Call<UserDataResponse>
}