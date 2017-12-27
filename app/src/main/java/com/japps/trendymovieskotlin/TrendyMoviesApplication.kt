package com.japps.trendymovieskotlin

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
* Created by jsmirabal on 12/27/2017.
*/
class  TrendyMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}