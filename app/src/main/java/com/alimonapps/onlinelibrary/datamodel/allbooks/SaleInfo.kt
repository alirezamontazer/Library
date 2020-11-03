package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class SaleInfo(
    @Json(name = "buyLink")
    val buyLink: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "isEbook")
    val isEbook: Boolean?,
    @Json(name = "listPrice")
    val listPrice: ListPrice?,
    @Json(name = "offers")
    val offers: List<Offer>?,
    @Json(name = "retailPrice")
    val retailPrice: RetailPriceX?,
    @Json(name = "saleability")
    val saleability: String?
) : Parcelable