package com.japps.trendymovieskotlin.adapter

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import com.japps.trendymovieskotlin.R
import com.japps.trendymovieskotlin.model.MovieModel
import com.japps.trendymovieskotlin.util.DateUtil
import com.japps.trendymovieskotlin.util.StringUtil
import com.japps.trendymovieskotlin.util.inflate


/**
 * Created by jsmirabal on 12/29/2017.
 */
class MainRecyclerAdapter(private var movieListData: MovieModel.MovieListData) : Adapter<MainRecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieData = movieListData.movies[position]
        val uri = Uri.parse("http://image.tmdb.org/t/p/w342/" + movieData.posterPath)
        holder.posterView.setImageURI(uri.toString())
        holder.dateTextView.text = DateUtil.getYear(movieData.releaseDate)
        holder.popularityTextView.text = StringUtil.formatPopularity(movieData.popularity)
        holder.ratingTextView.text = StringUtil.formatRating(movieData.rating)
    }

    override fun getItemCount(): Int = movieListData.movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.main_recycler_item))

    fun updateItems(newList: MovieModel.MovieListData) {
        movieListData = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var posterView: SimpleDraweeView = itemView.findViewById(R.id.poster_view)
        var popularityTextView: TextView = itemView.findViewById(R.id.popularity_text_view)
        var ratingTextView: TextView = itemView.findViewById(R.id.rating_text_view)
        var dateTextView: TextView = itemView.findViewById(R.id.date_text_view)
    }
}