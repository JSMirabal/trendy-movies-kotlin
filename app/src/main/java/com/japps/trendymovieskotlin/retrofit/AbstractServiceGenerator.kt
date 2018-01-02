package com.japps.trendymovieskotlin.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by jsmirabal on 12/31/2017.
 */
open class AbstractServiceGenerator<T>: ServiceBuilder<T>{

    override fun build(url: String, serviceClass: Class<T>, interceptor: Interceptor?): T {
        val builder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
        val httpClient = OkHttpClient.Builder()
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        if (interceptor != null) {
            httpClient.addInterceptor(interceptor)
        }
        builder.client(httpClient.build())
        return builder.build().create(serviceClass)
    }
}