package com.alimonapps.onlinelibrary.datamodel.allbooks


import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.alimonapps.onlinelibrary.datamodel.allbooks.ImageLinks
import com.alimonapps.onlinelibrary.datamodel.allbooks.IndustryIdentifier
import com.alimonapps.onlinelibrary.datamodel.allbooks.PanelizationSummary
import com.alimonapps.onlinelibrary.datamodel.allbooks.ReadingModes


@Parcelize
data class VolumeInfo(
    @Json(name = "allowAnonLogging")
    val allowAnonLogging: Boolean?,
    @Json(name = "authors")
    val authors: List<String>?,
    @Json(name = "averageRating")
    val averageRating: Float?,
    @Json(name = "canonicalVolumeLink")
    val canonicalVolumeLink: String?,
    @Json(name = "categories")
    val categories: List<String>?,
    @Json(name = "contentVersion")
    val contentVersion: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "imageLinks")
    val imageLinks: ImageLinks?,
    @Json(name = "industryIdentifiers")
    val industryIdentifiers: List<IndustryIdentifier>?,
    @Json(name = "infoLink")
    val infoLink: String?,
    @Json(name = "language")
    val language: String?,
    @Json(name = "maturityRating")
    val maturityRating: String?,
    @Json(name = "pageCount")
    val pageCount: Int?,
    @Json(name = "panelizationSummary")
    val panelizationSummary: PanelizationSummary?,
    @Json(name = "previewLink")
    val previewLink: String?,
    @Json(name = "printType")
    val printType: String?,
    @Json(name = "publishedDate")
    val publishedDate: String?,
    @Json(name = "publisher")
    val publisher: String?,
    @Json(name = "ratingsCount")
    val ratingsCount: Int?,
    @Json(name = "readingModes")
    val readingModes: ReadingModes?,
    @Json(name = "subtitle")
    val subtitle: String?,
    @Json(name = "title")
    val title: String?
) : Parcelable