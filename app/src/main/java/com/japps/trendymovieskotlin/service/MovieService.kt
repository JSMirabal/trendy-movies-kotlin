package com.japps.trendymovieskotlin.service

import com.japps.trendymovieskotlin.model.MovieViewState
import com.japps.trendymovieskotlin.util.*
import com.japps.trendymovieskotlin.util.MovieListSortingType.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by jsmirabal on 1/1/2018.
 */
class MovieService: AbstractService<MovieService.MovieApi>(MOVIE_DB_API_BASEPATH, MovieApi::class.java){

    fun fetchMovieList(sortBy: MovieListSortingType, page: String): Observable<MovieViewState.MovieListData>
            = service.fetchMovieList(buildMovieListParams(sortBy, page))

    private fun buildMovieListParams(sortBy: MovieListSortingType, page: String): MutableMap<String, String> {
        val paramsMap: MutableMap<String, String> = mutableMapOf()
        paramsMap[KEY_API] = MOVIE_DB_API_KEY
        paramsMap[KEY_PAGE] = page

        when(sortBy) {
            POPULARITY -> paramsMap[KEY_SORT_BY] = "popularity.desc"
            REVENUE -> paramsMap[KEY_SORT_BY] = "revenue.desc"
            RATING -> {
                paramsMap[KEY_SORT_BY] = "vote_average.desc"
                paramsMap[KEY_VOTE_COUNT_GTE] = "150"
            }
            UPCOMING -> {
                paramsMap[KEY_SORT_BY] = "primary_release_date.asc"
                paramsMap[KEY_VOTE_COUNT_GTE] = "10"
                paramsMap[KEY_PRIMARY_RELEASE_DATE_GTE] = DateUtil.getFormattedCurrentDate(DATE_PATTERN)
            }
            NOW_PLAYING -> {
                paramsMap[KEY_SORT_BY] = "popularity.desc"
                paramsMap[KEY_VOTE_COUNT_GTE] = "10"
                paramsMap[KEY_PRIMARY_RELEASE_DATE_GTE] = DateUtil.getDateFrom60days(DATE_PATTERN)
                paramsMap[KEY_PRIMARY_RELEASE_DATE_LTE] = DateUtil.getFormattedCurrentDate(DATE_PATTERN)
            }
        }

        return paramsMap
    }

    interface MovieApi {
        @GET("3/discover/movie")
        fun fetchMovieList(
                @QueryMap params: MutableMap<String, String>
        ): Observable<MovieViewState.MovieListData>
    }
}