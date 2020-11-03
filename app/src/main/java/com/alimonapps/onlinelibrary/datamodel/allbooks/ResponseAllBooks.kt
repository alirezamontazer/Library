package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.alimonapps.onlinelibrary.datamodel.allbooks.Item


@Parcelize
data class ResponseAllBooks(
    @Json(name = "items")
    val items: List<Item>?,
    @Json(name = "kind")
    val kind: String?,
    @Json(name = "totalItems")
    val totalItems: Int?
) : Parcelable