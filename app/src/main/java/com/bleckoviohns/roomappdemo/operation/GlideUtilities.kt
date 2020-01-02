package com.bleckoviohns.roomappdemo.operation

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

fun ImageView.CircleImage(url : String = "",context: Context) {
    if (isValidContextForGlide(context)){
       /* Glide.with(context)
            .load(url)
            .apply(RequestOptions.circleCropTransform())
            .into(this)*/

        Glide.with(context)
            .load(url)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .transition(DrawableTransitionOptions().crossFade())
            .into(this)
    }
}

fun isValidContextForGlide(context: Context?): Boolean {
    context?.let {
        if (it is Activity) {
            if (it.isDestroyed) {
                return false
            }
        }
        return true
    }
    return false
}