package com.bleckoviohns.roomappdemo.models.Api

import android.os.Build
import com.bleckoviohns.roomappdemo.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object HttpCapptuApiAdapter {
    private var API_SERVICE: HttpCapptuApiService? = null
    var BASE_URL_DJANGO = ""

    val apiService: HttpCapptuApiService
        get() {

            val BaseURL = BASE_URL_DJANGO
            if (API_SERVICE == null) {

                val interceptor  = Interceptor { chain ->
                    var request = chain.request()
                    request = request.newBuilder()
                        .addHeader("User-Agent", "Capptu/" + BuildConfig.VERSION_NAME + " | Android " + Build.VERSION.RELEASE + " | " + Build.MANUFACTURER.toUpperCase() + " " + Build.MODEL)
                        .build()
                    val response = chain.proceed(request)
                    response
                }

                val interceptorDebug = HttpLoggingInterceptor()
                if (BuildConfig.DEBUG)
                    interceptorDebug.level = HttpLoggingInterceptor.Level.BODY

                val client = OkHttpClient.Builder()
                    .addInterceptor(if (BuildConfig.DEBUG) interceptorDebug else interceptor)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                API_SERVICE = retrofit.create(HttpCapptuApiService::class.java)
            }
            return API_SERVICE!!
        }
}