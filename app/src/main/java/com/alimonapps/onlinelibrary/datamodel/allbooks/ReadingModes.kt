package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class ReadingModes(
    @Json(name = "image")
    val image: Boolean?,
    @Json(name = "text")
    val text: Boolean?
) : Parcelable