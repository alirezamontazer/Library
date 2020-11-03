package com.alimonapps.onlinelibrary.datamodel.bestpodcast


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Extra(
    @Json(name = "facebook_handle")
    val facebookHandle: String?,
    @Json(name = "google_url")
    val googleUrl: String?,
    @Json(name = "instagram_handle")
    val instagramHandle: String?,
    @Json(name = "linkedin_url")
    val linkedinUrl: String?,
    @Json(name = "patreon_handle")
    val patreonHandle: String?,
    @Json(name = "spotify_url")
    val spotifyUrl: String?,
    @Json(name = "twitter_handle")
    val twitterHandle: String?,
    @Json(name = "url1")
    val url1: String?,
    @Json(name = "url2")
    val url2: String?,
    @Json(name = "url3")
    val url3: String?,
    @Json(name = "wechat_handle")
    val wechatHandle: String?,
    @Json(name = "youtube_url")
    val youtubeUrl: String?
) : Parcelable