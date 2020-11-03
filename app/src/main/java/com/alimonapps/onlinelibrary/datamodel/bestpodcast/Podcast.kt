package com.alimonapps.onlinelibrary.datamodel.bestpodcast


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class Podcast(
    @Json(name = "country")
    val country: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "earliest_pub_date_ms")
    val earliestPubDateMs: Long?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "explicit_content")
    val explicitContent: Boolean?,
    @Json(name = "extra")
    val extra: Extra?,
    @Json(name = "genre_ids")
    val genreIds: List<Int>?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "is_claimed")
    val isClaimed: Boolean?,
    @Json(name = "itunes_id")
    val itunesId: Int?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "latest_pub_date_ms")
    val latestPubDateMs: Long?,
    @Json(name = "listennotes_url")
    val listennotesUrl: String?,
    @Json(name = "looking_for")
    val lookingFor: LookingFor?,
    @Json(name = "publisher")
    val publisher: String?,
    @Json(name = "rss")
    val rss: String?,
    @Json(name = "thumbnail")
    val thumbnail: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "total_episodes")
    val totalEpisodes: Int?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "website")
    val website: String?
) : Parcelable