package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class ListPriceX(
    @Json(name = "amountInMicros")
    val amountInMicros: Int?,
    @Json(name = "currencyCode")
    val currencyCode: String?
) : Parcelable