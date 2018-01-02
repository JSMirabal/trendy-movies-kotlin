package com.japps.trendymovieskotlin.util


/**
 * Created by jsmirabal on 1/1/2018.
 */

enum class MovieListSortingType {
    POPULARITY, RATING, UPCOMING, NOW_PLAYING, REVENUE
}

// Base paths
const val IMAGE_W154_BASEPATH = "http://image.tmdb.org/t/p/w154"
const val IMAGE_W185_BASEPATH = "http://image.tmdb.org/t/p/w185"
const val IMAGE_W342_BASEPATH = "http://image.tmdb.org/t/p/w342"
const val IMAGE_W500_BASEPATH = "http://image.tmdb.org/t/p/w500"
const val YOUTUBE_THUMBNAIL_BASEPATH = "http://img.youtube.com/vi/"
const val YOUTUBE_WATCH_BASEPATH = "https://www.youtube.com/watch?v="
const val MOVIE_DB_API_BASEPATH = "http://api.themoviedb.org/"

/**
 *  @see com.japps.trendymovieskotlin.service.MovieService.buildMovieListParams()
 */
const val KEY_API = "api_key"
const val KEY_PAGE = "page"
const val KEY_SORT_BY = "sort_by"
const val KEY_VOTE_COUNT_GTE = "vote_count.gte"
const val KEY_PRIMARY_RELEASE_DATE_GTE = "primary_release_date.gte"
const val KEY_PRIMARY_RELEASE_DATE_LTE = "primary_release_date.lte"

// Date
const val DATE_PATTERN = "yyyy-MM-dd"