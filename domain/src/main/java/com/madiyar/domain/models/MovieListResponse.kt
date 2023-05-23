package com.madiyar.domain.models

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("page")
    val page:Int?,
    @SerializedName("results")
    val results:List<Result?>?,
    @SerializedName("total_pages")
    val totalPages:Int?,
    @SerializedName("total_results")
    val totalResults:Int?
)
{
    data class Result(
        @SerializedName("adult")
        val adult: Boolean?,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        @SerializedName("genre_ids")
        val genreIds: List<Int?>?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("original_language")
        val originalLanguage:String?,
        @SerializedName("original_title")
        var originalTitle: String?,
        @SerializedName("overview")
        var overvew: String?,
        @SerializedName("popularity")
        var popularity: Double?,
        @SerializedName("poster_path")
        var posterPath: String?,
        @SerializedName("release_date")
        var releaseDate: String?,
        @SerializedName("title")
        var title: String?,
        @SerializedName("video")
        val video: Boolean?,
        @SerializedName("vote_average")
        var voteAvarage: Double?,
        @SerializedName("vote_count")
        val voteCount: Int?
    )
}
