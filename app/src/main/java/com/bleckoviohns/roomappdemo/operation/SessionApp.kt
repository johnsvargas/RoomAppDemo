package com.bleckoviohns.roomappdemo.operation

import android.content.Context
import android.content.SharedPreferences
import com.bleckoviohns.roomappdemo.entities.User

object SessionApp {
    const val APP_SESSION = "CAPPTU_ADMIN"

    val ID_USER = ::idUser.name
    val USER_NAME = ::userName.name
    val USER_LASTNAME = ::userLastName.name
    val USER_ALIAS = ::userAlias.name
    val USER_TOKEN = :: userToken.name
    val USER_PHOTOS_PERFIL = :: userPhotoPerfil.name

    var idUser : Int = 0
    var userName = ""
    var userLastName = ""
    var userAlias = ""
    var userToken = "token "
    var userPhotoPerfil = ""

    private lateinit var prefs: SharedPreferences

    fun init(context : Context) {
        prefs = context.getSharedPreferences(APP_SESSION,Context.MODE_PRIVATE)
    }

    fun initialSessionApp(user : User){
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor){
            putInt(ID_USER,user.idUser)
            putString(USER_NAME,user.firstName)
            putString(USER_LASTNAME,user.lastName)
            putString(USER_ALIAS,user.alias)
            putString(USER_TOKEN, userToken + userToken)
            putString(USER_PHOTOS_PERFIL,user.photoUrl)
            commit()
        }
    }

    private fun initialValues(user: User){
        idUser = user.idUser
        userName = user.firstName?:""
        userLastName = user.lastName?:""
        userAlias = user.alias?:""
        userToken = user.token?:""
        userPhotoPerfil = user.photoUrl

    }

    fun read(key: String, value: String): String? {
        return prefs.getString(key, value)
    }

    fun read(key: String, value: Long): Long? {
        return prefs.getLong(key, value)
    }

    fun write(key: String, value: String) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putString(key, value)
            commit()
        }
    }

    fun write(key: String, value: Long) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putLong(key, value)
            commit()
        }
    }
}