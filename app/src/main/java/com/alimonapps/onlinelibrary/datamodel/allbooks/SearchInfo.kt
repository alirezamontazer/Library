package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class SearchInfo(
    @Json(name = "textSnippet")
    val textSnippet: String?
) : Parcelable