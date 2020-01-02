package com.bleckoviohns.roomappdemo.viewmodel

import android.content.Context
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bleckoviohns.roomappdemo.models.PortfolioObservable
import android.widget.ImageView

import com.bleckoviohns.roomappdemo.operation.CircleImage


class PortfolioViewModel() : ViewModel(){
    private val portfolioObservable = PortfolioObservable()

    fun getUserData() = portfolioObservable.getUserData()

    fun getReponseUserData(idUser:Int,token:String){
        portfolioObservable.getResponseUserData(idUser, token)
    }

}

/*@BindingAdapter("profileImage")
fun loadImage(view: ImageView, imageUrl: String = "") {
    view.CircleImage(imageUrl,view.context)
}*/