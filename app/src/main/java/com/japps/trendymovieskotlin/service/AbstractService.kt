package com.japps.trendymovieskotlin.service

import com.japps.trendymovieskotlin.BuildConfig
import com.japps.trendymovieskotlin.retrofit.ConcreteServiceGenerator

/**
 * Created by jsmirabal on 1/1/2018.
 */
open class AbstractService<out T: Any>(baseUrl: String, api: Class<T>) {
    protected val MOVIE_DB_API_KEY = BuildConfig.MOVIE_DB_API_KEY
    protected val service = ConcreteServiceGenerator.instance<T>().create(baseUrl, api)
}