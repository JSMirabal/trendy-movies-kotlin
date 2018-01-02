package com.japps.trendymovieskotlin.service

import com.japps.trendymovieskotlin.model.MovieModel
import com.japps.trendymovieskotlin.util.DateUtil
import com.japps.trendymovieskotlin.util.MovieListSortingType
import com.japps.trendymovieskotlin.util.MovieListSortingType.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by jsmirabal on 1/1/2018.
 */
class MovieService: AbstractService<MovieService.MovieApi>("http://api.themoviedb.org/", MovieApi::class.java){

    fun fetchMovieList(sortBy: MovieListSortingType, page: String): Observable<MovieModel.MovieListData>
            = service.fetchMovieList(buildParams(sortBy, page))

    private fun buildParams(sortBy: MovieListSortingType, page: String): MutableMap<String, String> {
        val paramsMap: MutableMap<String, String> = mutableMapOf()
        paramsMap["api_key"] = API_KEY
        paramsMap["page"] = page

        when(sortBy) {
            POPULARITY -> paramsMap["sort_by"] = "popularity.desc"
            REVENUE -> paramsMap["sort_by"] = "revenue.desc"
            RATING -> {
                paramsMap["sort_by"] = "vote_average.desc"
                paramsMap["vote_count.gte"] = "150"
            }
            UPCOMING -> {
                paramsMap["sort_by"] = "primary_release_date.asc"
                paramsMap["vote_count.gte"] = "10"
                paramsMap["primary_release_date.gte"] = DateUtil.getFormattedCurrentDate("yyyy-MM-dd")
            }
            NOW_PLAYING -> {
                paramsMap["sort_by"] = "popularity.desc"
                paramsMap["vote_count.gte"] = "10"
                paramsMap["primary_release_date.gte"] = DateUtil.getDateFrom60days("yyyy-MM-dd")
                paramsMap["primary_release_date.lte"] = DateUtil.getFormattedCurrentDate("yyyy-MM-dd")
            }
        }

        return paramsMap
    }

    interface MovieApi {
        @GET("3/discover/movie")
        fun fetchMovieList(
                @QueryMap params: MutableMap<String, String>
        ): Observable<MovieModel.MovieListData>
    }
}