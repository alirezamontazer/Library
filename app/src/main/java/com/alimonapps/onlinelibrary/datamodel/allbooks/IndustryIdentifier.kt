package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class IndustryIdentifier(
    @Json(name = "identifier")
    val identifier: String?,
    @Json(name = "type")
    val type: String?
) : Parcelable