package com.japps.trendymovieskotlin.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.View
import android.view.ViewGroup
import com.japps.trendymovieskotlin.R
import com.japps.trendymovieskotlin.util.inflate

/**
 * Created by jsmirabal on 12/29/2017.
 */
class MainRecyclerAdapter : Adapter<MainRecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    }

    override fun getItemCount(): Int = 6

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.main_recycler_item))

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}