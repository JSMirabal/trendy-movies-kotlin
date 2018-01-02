package com.japps.trendymovieskotlin.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jsmirabal on 1/2/2018.
 */
class DateUtil{
    companion object {
        fun getFormattedCurrentDate(pattern: String): String = SimpleDateFormat(pattern, Locale.getDefault()).format(Date())

        fun getDateFrom60days(pattern: String): String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE, -60)
            val date = calendar.time
            return SimpleDateFormat(pattern, Locale.getDefault()).format(date)
        }

        fun getYear(dateStr: String): String {
            try {
                val date = SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(dateStr)
                return SimpleDateFormat("yyyy", Locale.getDefault()).format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return dateStr
        }
    }
}