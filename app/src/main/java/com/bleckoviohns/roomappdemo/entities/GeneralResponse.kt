package com.bleckoviohns.roomappdemo.entities

import com.google.gson.annotations.SerializedName

data class GeneralResponse (var type: Int = 0, var detail: String = "", @SerializedName("userData")
    var isUserData: Boolean = false, var url: String = "", var enable : Boolean = false
)
