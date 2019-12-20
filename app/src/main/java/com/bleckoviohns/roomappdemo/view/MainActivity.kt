package com.bleckoviohns.roomappdemo.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bleckoviohns.roomappdemo.R
import com.bleckoviohns.roomappdemo.operation.openActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = Handler()
        handler.postDelayed({this.openActivity(LoginActivity::class.java)},1000)
    }
}
