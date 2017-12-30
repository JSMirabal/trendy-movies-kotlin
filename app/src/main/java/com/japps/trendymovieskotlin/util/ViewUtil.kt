package com.japps.trendymovieskotlin.util

import com.japps.trendymovieskotlin.application.TrendyMoviesApplication

/**
 * Created by jsmirabal on 12/30/2017.
 */

fun getPixelFromDimen(dimenId: Int): Int
        = TrendyMoviesApplication.get.resources.getDimensionPixelOffset(dimenId)