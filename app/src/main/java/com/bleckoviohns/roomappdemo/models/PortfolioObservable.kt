package com.bleckoviohns.roomappdemo.models

import androidx.databinding.BaseObservable

class PortfolioObservable :BaseObservable(){
    private var portfolioRepositorylio = PortfolioRepository()

    fun getUserData() = portfolioRepositorylio.getUserData()

    fun getResponseUserData(idUser:Int, token:String){
        portfolioRepositorylio.getResposeUserData(idUser, token)
    }
}