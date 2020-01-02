package com.bleckoviohns.roomappdemo.entities


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by Juan Carlos on 01/06/2018.
 */

class UserDataResponse : Parcelable {

    var id_user: Int = 0// id_user
    var str_mail: String? = null// str_mail
    var str_alias: String? = null// str_alias
    var str_firstname: String? = null// str_firstname
    var str_lastname: String? = null// str_lastname
    var str_prophoto: String? = null// str_prophoto
    var str_biography: String? = null// str_biography
    var random_image: String? = null// random_image
    var cover_photo: String? = null// cover_photo
    var str_contactmail: String? = null// str_contactmail
    var has_contact_mail: Int = 0// has_contact_mail
    var paypal_mail: String? = null
    @SerializedName("notification")
    var isNotification: Boolean = false// noification
    @SerializedName("elite")
    var isElite: Boolean = false// elite
    var birthday: String? = null
    var age: Int = 0// age
    var gender: String? = null// gender
    var since: String? = null// since
    var is_following: Boolean = false// is_following
    var photos_total: Int = 0// photos_total
    var photos_sold: Int = 0// photos_sold
    var for_sale: Int = 0// for_sale
    var mission_photos: Int = 0// mission_photos
    var missions: Int = 0// missions
    var won: Int = 0// won
    var followers: Int = 0// followers
    var followers_images: ArrayList<String>? = null// followers_images
    var following: Int = 0// following
    var following_images: ArrayList<String>? = null// following_images
    var likes: Int = 0// likes
    var views: Int = 0// views
    var closeout: Float = 0.toFloat()// closeout
    var country: String? = null// country
    var state: String? = null// state
    var city: String? = null// city

    //functions customs
    val aliasWithAt: String
        get() = "@" + str_alias!!

    constructor(id_user: Int, is_following: Boolean) {
        this.id_user = id_user
        this.is_following = is_following
    }


    internal constructor() {}
    protected constructor(`in`: Parcel) {
        id_user = `in`.readInt()
        str_mail = `in`.readString()
        str_alias = `in`.readString()
        str_firstname = `in`.readString()
        str_lastname = `in`.readString()
        str_prophoto = `in`.readString()
        str_biography = `in`.readString()
        random_image = `in`.readString()
        cover_photo = `in`.readString()
        str_contactmail = `in`.readString()
        has_contact_mail = `in`.readInt()
        paypal_mail = `in`.readString()
        isNotification = `in`.readByte().toInt() != 0
        isElite = `in`.readByte().toInt() != 0
        birthday = `in`.readString()
        age = `in`.readInt()
        gender = `in`.readString()
        since = `in`.readString()
        is_following = `in`.readByte().toInt() != 0
        photos_total = `in`.readInt()
        photos_sold = `in`.readInt()
        for_sale = `in`.readInt()
        mission_photos = `in`.readInt()
        missions = `in`.readInt()
        won = `in`.readInt()
        followers = `in`.readInt()
        followers_images = `in`.createStringArrayList()
        following = `in`.readInt()
        following_images = `in`.createStringArrayList()
        likes = `in`.readInt()
        views = `in`.readInt()
        closeout = `in`.readFloat()
        country = `in`.readString()
        state = `in`.readString()
        city = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id_user)
        dest.writeString(str_mail)
        dest.writeString(str_alias)
        dest.writeString(str_firstname)
        dest.writeString(str_lastname)
        dest.writeString(str_prophoto)
        dest.writeString(str_biography)
        dest.writeString(random_image)
        dest.writeString(cover_photo)
        dest.writeString(str_contactmail)
        dest.writeInt(has_contact_mail)
        dest.writeString(paypal_mail)
        dest.writeByte((if (isNotification) 1 else 0).toByte())
        dest.writeByte((if (isElite) 1 else 0).toByte())
        dest.writeString(birthday)
        dest.writeInt(age)
        dest.writeString(gender)
        dest.writeString(since)
        dest.writeByte((if (is_following) 1 else 0).toByte())
        dest.writeInt(photos_total)
        dest.writeInt(photos_sold)
        dest.writeInt(for_sale)
        dest.writeInt(mission_photos)
        dest.writeInt(missions)
        dest.writeInt(won)
        dest.writeInt(followers)
        dest.writeStringList(followers_images)
        dest.writeInt(following)
        dest.writeStringList(following_images)
        dest.writeInt(likes)
        dest.writeInt(views)
        dest.writeFloat(closeout)
        dest.writeString(country)
        dest.writeString(state)
        dest.writeString(city)
    }

    companion object {

        @JvmField val CREATOR: Parcelable.Creator<UserDataResponse> = object : Parcelable.Creator<UserDataResponse> {
            override fun createFromParcel(`in`: Parcel): UserDataResponse {
                return UserDataResponse(`in`)
            }

            override fun newArray(size: Int): Array<UserDataResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}
