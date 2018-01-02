package com.japps.trendymovieskotlin.retrofit

import okhttp3.Interceptor

/**
 * Created by jsmirabal on 1/1/2018.
 */
class ConcreteServiceGenerator<T: Any> private constructor(): AbstractServiceGenerator<T>() {
    private lateinit var currentUrl: String
    private lateinit var service: T
    companion object {
        fun <T: Any> instance(): ConcreteServiceGenerator<T> = ConcreteServiceGenerator()
    }

    fun create(newUrl: String, api: Class<T>, interceptor: Interceptor? = null): T {
        if(!::service.isInitialized || newUrl != currentUrl) {
            service = super.build(newUrl, api, interceptor)
            currentUrl = newUrl
        }
        return service
    }
}
