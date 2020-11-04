package com.alimonapps.onlinelibrary.datamodel.searchaudio


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class ResponseAudioSearch(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "next_offset")
    val nextOffset: Int?,
    @Json(name = "results")
    val results: List<Result>?,
    @Json(name = "took")
    val took: Double?,
    @Json(name = "total")
    val total: Int?
) : Parcelable