package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Offer(
    @Json(name = "finskyOfferType")
    val finskyOfferType: Int?,
    @Json(name = "giftable")
    val giftable: Boolean?,
    @Json(name = "listPrice")
    val listPrice: ListPriceX?,
    @Json(name = "retailPrice")
    val retailPrice: RetailPrice?
) : Parcelable