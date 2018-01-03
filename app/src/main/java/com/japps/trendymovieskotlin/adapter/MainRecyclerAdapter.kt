package com.japps.trendymovieskotlin.adapter

import android.net.Uri
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.View
import android.view.ViewGroup
import com.japps.trendymovieskotlin.R
import com.japps.trendymovieskotlin.databinding.MainRecyclerItemBinding
import com.japps.trendymovieskotlin.model.MovieViewState
import com.japps.trendymovieskotlin.util.*


/**
 * Created by jsmirabal on 12/29/2017.
 */
class MainRecyclerAdapter(private var movieListData: MovieViewState.MovieListData) : Adapter<MainRecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieData = movieListData.movies[position]
        val uri = Uri.parse("$IMAGE_W342_BASEPATH${movieData.posterPath}")
        holder.mBinding.posterView.setImageURI(uri.toString())
        holder.mBinding.dateTextView.text = DateUtil.getYear(movieData.releaseDate)
        holder.mBinding.popularityTextView.text = StringUtil.formatPopularity(movieData.popularity)
        holder.mBinding.ratingTextView.text = StringUtil.formatRating(movieData.rating)
    }

    override fun getItemCount(): Int = movieListData.movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
            = ViewHolder(parent.inflate(R.layout.main_recycler_item))

    fun updateItems(newList: MovieViewState.MovieListData) {
        DiffUtil.calculateDiff(MoviesDiffUtil(movieListData, newList), true)
                .dispatchUpdatesTo(this)
        movieListData = newList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mBinding: MainRecyclerItemBinding = MainRecyclerItemBinding.bind(itemView)
    }

    class MoviesDiffUtil(private var oldList: MovieViewState.MovieListData, private var newList: MovieViewState.MovieListData): DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList.movies[oldItemPosition].id == newList.movies[newItemPosition].id
        }

        override fun getOldListSize(): Int = oldList.movies.size

        override fun getNewListSize(): Int = newList.movies.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList.movies[oldItemPosition] == newList.movies[newItemPosition]
        }
    }
}