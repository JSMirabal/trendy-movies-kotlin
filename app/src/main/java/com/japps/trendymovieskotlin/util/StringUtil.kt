package com.japps.trendymovieskotlin.util

import java.util.*

/**
 * Created by jsmirabal on 1/2/2018.
 */
class StringUtil {
    companion object {
        fun formatPopularity(popularity: Double): String {
            return String.format(Locale.getDefault(), "%.0f", popularity)
        }

        fun formatRating(rating: Double): String {
            return String.format(Locale.getDefault(), "%.1f", rating)
        }
    }
}