package com.japps.trendymovieskotlin.retrofit

import okhttp3.Interceptor

/**
 * Created by jsmirabal on 1/1/2018.
 */
interface ServiceBuilder<T> {
    val TIMEOUT: Long get() = 30
    fun build(url: String, serviceClass: Class<T>, interceptor: Interceptor?): T
}