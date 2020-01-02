package com.bleckoviohns.roomappdemo.entities

import com.google.gson.annotations.SerializedName

class ResponseUser {
    var last_name: String? = null
    var userdata: Boolean? = null
    var token: String? = null
    var first_name: String? = null
    var alias: String? = null
    var gender: String? = null
    var id: Int = 0
    var birthday: String? = null
    var is_valid: Int = 0
    var email: String? = null
    var facebook_id: String? = null
    var profile_photo: String? = null
    var location: String? = null
    var zipcode: String? = null
    var state: String? = null
    var city: String? = null
    @SerializedName("version")
    var versionTerms: Int = 0
    var pass = ""
    constructor(email:String,password:String){
        this.email = email
        this.pass = password
    }
}