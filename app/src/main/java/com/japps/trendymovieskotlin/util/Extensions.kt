package com.japps.trendymovieskotlin.util

import android.support.annotation.LayoutRes
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by jsmirabal on 12/29/2017.
 */

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    Log.d(this.javaClass.name, "Inflate")
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}