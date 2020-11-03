package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class AccessInfo(
    @Json(name = "accessViewStatus")
    val accessViewStatus: String?,
    @Json(name = "country")
    val country: String?,
    @Json(name = "embeddable")
    val embeddable: Boolean?,
    @Json(name = "epub")
    val epub: Epub?,
    @Json(name = "pdf")
    val pdf: Pdf?,
    @Json(name = "publicDomain")
    val publicDomain: Boolean?,
    @Json(name = "quoteSharingAllowed")
    val quoteSharingAllowed: Boolean?,
    @Json(name = "textToSpeechPermission")
    val textToSpeechPermission: String?,
    @Json(name = "viewability")
    val viewability: String?,
    @Json(name = "webReaderLink")
    val webReaderLink: String?
) : Parcelable