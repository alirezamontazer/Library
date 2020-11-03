package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class ListPrice(
    @Json(name = "amount")
    val amount: Double?,
    @Json(name = "currencyCode")
    val currencyCode: String?
) : Parcelable