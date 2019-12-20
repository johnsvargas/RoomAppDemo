package com.bleckoviohns.roomappdemo.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName:String?,
    @ColumnInfo(name = "alias") val alias:String?,
    @ColumnInfo(name = "idUser") val idUser:Int,
    @ColumnInfo(name = "photoUrl") val photoUrl:String,
    @ColumnInfo(name = "token") val token:String,
    @ColumnInfo(name = "email") val email:String?,
    @Ignore val password:String?
)