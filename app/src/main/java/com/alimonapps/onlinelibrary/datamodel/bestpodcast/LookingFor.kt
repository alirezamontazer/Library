package com.alimonapps.onlinelibrary.datamodel.bestpodcast


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class LookingFor(
    @Json(name = "cohosts")
    val cohosts: Boolean?,
    @Json(name = "cross_promotion")
    val crossPromotion: Boolean?,
    @Json(name = "guests")
    val guests: Boolean?,
    @Json(name = "sponsors")
    val sponsors: Boolean?
) : Parcelable