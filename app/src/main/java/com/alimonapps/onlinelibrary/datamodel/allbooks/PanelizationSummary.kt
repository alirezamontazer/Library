package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class PanelizationSummary(
    @Json(name = "containsEpubBubbles")
    val containsEpubBubbles: Boolean?,
    @Json(name = "containsImageBubbles")
    val containsImageBubbles: Boolean?
) : Parcelable