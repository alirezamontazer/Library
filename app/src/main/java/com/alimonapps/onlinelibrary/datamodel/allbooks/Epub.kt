package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Epub(
    @Json(name = "acsTokenLink")
    val acsTokenLink: String?,
    @Json(name = "isAvailable")
    val isAvailable: Boolean?
) : Parcelable