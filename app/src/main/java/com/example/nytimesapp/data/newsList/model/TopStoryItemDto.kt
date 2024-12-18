
package com.example.nytimesapp.data.newsList.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TopStoryItemDto(

    @SerializedName("abstract")
    @Expose
    val abstract: String,

    @SerializedName("byline")
    @Expose
    val byline: String,

    @SerializedName("createdDate")
    @Expose
    val createdDate: String,

    @SerializedName("desFacet")
    @Expose
    val desFacet: List<String>,

    @SerializedName("geoFacet")
    @Expose
    val geoFacet: List<String>,

    @SerializedName("itemType")
    @Expose
    val itemType: String,

    @SerializedName("kicker")
    @Expose
    val kicker: String,

    @SerializedName("materialTypeFacet")
    @Expose
    val materialTypeFacet: String,

    @SerializedName("multimedia")
    @Expose
    val multimedia: List<TopStoriesItemMultimediaDto>,

    @SerializedName("orgFacet")
    @Expose
    val orgFacet: List<String>,

    @SerializedName("perFacet")
    @Expose
    val perFacet: List<String>,

    @SerializedName("publishedDate")
    @Expose
    val publishedDate: String,

    @SerializedName("section")
    @Expose
    val section: String,

    @SerializedName("shortUrl")
    @Expose
    val shortUrl: String,

    @SerializedName("subsection")
    @Expose
    val subsection: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("updatedDate")
    @Expose
    val updatedDate: String,

    @SerializedName("uri")
    @Expose
    val uri: String,

    @SerializedName("url")
    @Expose
    val url: String
)
