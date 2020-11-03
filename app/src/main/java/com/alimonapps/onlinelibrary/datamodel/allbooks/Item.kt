package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Item(
    @Json(name = "accessInfo")
    val accessInfo: AccessInfo?,
    @Json(name = "etag")
    val etag: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "kind")
    val kind: String?,
    @Json(name = "saleInfo")
    val saleInfo: SaleInfo?,
    @Json(name = "searchInfo")
    val searchInfo: SearchInfo?,
    @Json(name = "selfLink")
    val selfLink: String?,
    @Json(name = "volumeInfo")
    val volumeInfo: VolumeInfo?
) : Parcelable