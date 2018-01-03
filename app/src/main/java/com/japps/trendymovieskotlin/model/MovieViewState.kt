package com.japps.trendymovieskotlin.model

import com.google.gson.annotations.SerializedName

/**
 * Created by jsmirabal on 12/31/2017.
 */

sealed class MovieViewState {
    data class MovieData(
            @SerializedName("id") val id: Int,
            @SerializedName("title") val title: String,
            @SerializedName("poster_path") val posterPath: String,
            @SerializedName("vote_average") val rating: Double,
            @SerializedName("popularity") val popularity: Double,
            @SerializedName("release_date") val releaseDate: String
    ): MovieViewState()

    data class MovieListData(
            @SerializedName("results") val movies: List<MovieViewState.MovieData>
    ): MovieViewState()

    object Loading: MovieViewState()
    object EmptyResponse: MovieViewState()
    object ErrorResponse: MovieViewState()
}