package com.bleckoviohns.roomappdemo.models.Api


import com.bleckoviohns.roomappdemo.entities.ResponseUser
import com.bleckoviohns.roomappdemo.entities.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface HttpCapptuApiService {
    @FormUrlEncoded
    @POST("login/")
    fun PostLogin(@Field("email") email: String, @Field("password") password: String, @Field("version") version: Int,
                  @Field("ios_token") ios_token: String, @Field("android_token") android_token: String): Call<ResponseUser>
}