package com.alimonapps.onlinelibrary.datamodel.bestpodcast


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable


@Parcelize
data class ResponseBestPodcast(
    @Json(name = "has_next")
    val hasNext: Boolean?,
    @Json(name = "has_previous")
    val hasPrevious: Boolean?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "listennotes_url")
    val listennotesUrl: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "next_page_number")
    val nextPageNumber: Int?,
    @Json(name = "page_number")
    val pageNumber: Int?,
//    @Json(name = "parent_id")
//    val parentId: Any?,
    @Json(name = "podcasts")
    val podcasts: List<Podcast>?,
    @Json(name = "previous_page_number")
    val previousPageNumber: Int?,
    @Json(name = "total")
    val total: Int?
) : Parcelable