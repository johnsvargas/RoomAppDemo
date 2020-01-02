package com.bleckoviohns.roomappdemo.entities

import android.util.Log
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import retrofit2.Response
import java.io.IOException

data class ErrorsAppCapptu(var description:String = "",var type:Int = 0,var classification:ErrorClassification = ErrorClassification.ERROR)
enum class ErrorClassification {ERROR,WARNING}


fun <T> getErrorMessage(response: Response<T>):ErrorsAppCapptu{
    val responseGeneral = convertResponseToGeneralResponse(response)
    return ErrorsAppCapptu(responseGeneral?.detail?:"",responseGeneral?.type?:0)
}

@Throws(IOException::class)
fun convertResponseToGeneralResponse(response: Response<*>): GeneralResponse? {
    try {
        val gson = GsonBuilder().create()
        return gson.fromJson(
            response.errorBody()!!.string(),
            GeneralResponse::class.java
        )
    } catch (e: IOException) {
        Log.d("", e.message?:"")
        return GeneralResponse(0,"Error General")
    } catch (e: IllegalStateException) {
        Log.d("", e.message?:"")
        return GeneralResponse(0,"Error General")
    } catch (e: JsonSyntaxException) {
        Log.d("", e.message?:"")
        return GeneralResponse(0,"Error General")
    }

}