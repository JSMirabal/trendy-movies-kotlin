package com.japps.trendymovieskotlin.interactor

import com.japps.trendymovieskotlin.model.MovieViewState
import com.japps.trendymovieskotlin.service.MovieService
import com.japps.trendymovieskotlin.util.MovieListSortingType
import io.reactivex.Observable

/**
 * Created by jsmirabal on 1/2/2018.
 */
class MovieInteractor {
    private val mService: MovieService = MovieService()

    fun fetchMovieList(sortBy: MovieListSortingType, page: String): Observable<MovieViewState> {
        return mService.fetchMovieList(sortBy, page)
                .map ({ movieListData ->
                    when(movieListData.movies.isEmpty()) {
                        true -> MovieViewState.EmptyResponse
                        else -> MovieViewState.MovieListData(movieListData.movies)
                    }
                })
                .startWith(MovieViewState.Loading)
                .onErrorReturn({ error -> MovieViewState.ErrorResponse })
    }
}