package com.alimonapps.onlinelibrary

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

//load image url directly with glide
@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if (url?.isNotEmpty() == true) Glide.with(context).load(url)
        .into(this)
}