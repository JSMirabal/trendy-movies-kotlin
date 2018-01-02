package com.japps.trendymovieskotlin.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.MenuItem
import com.japps.trendymovieskotlin.R
import com.japps.trendymovieskotlin.adapter.MainRecyclerAdapter
import com.japps.trendymovieskotlin.databinding.ActivityMainBinding
import com.japps.trendymovieskotlin.decoration.ItemOffsetDecoration
import com.japps.trendymovieskotlin.model.MovieModel
import com.japps.trendymovieskotlin.service.MovieService
import com.japps.trendymovieskotlin.util.MovieListSortingType
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        initLoading()
    }

    private fun initLoading() {
        MovieService().fetchMovieList(MovieListSortingType.POPULARITY, "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {response -> setupRecycler(response)},
                        {error -> Log.e(javaClass.name, "Error fetching movie list: " + error.toString())}
                )
    }

    private fun fetchMovies(sortBy: MovieListSortingType, page: String) {
        MovieService().fetchMovieList(sortBy, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {response -> mAdapter.updateItems(response)},
                        {error -> Log.e(javaClass.name, "Error fetching movie list: " + error.toString())}
                )
    }

    private fun setupRecycler(movieList: MovieModel.MovieListData) {
        mAdapter = MainRecyclerAdapter(movieList)
        mBinding.mainRecyclerView.layoutManager = GridLayoutManager(this, 2)
        mBinding.mainRecyclerView.adapter = mAdapter
        mBinding.mainRecyclerView.addItemDecoration(ItemOffsetDecoration(R.dimen.size_tiny))
    }

    private fun setupBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.self = this
        mBinding.bottomNavigation.menu.findItem(R.id.nav_trending).isChecked = true
        mBinding.executePendingBindings()
    }

    fun onBottomNavigationItemClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_trending -> fetchMovies(MovieListSortingType.POPULARITY, "1")
            R.id.nav_top_rated -> fetchMovies(MovieListSortingType.RATING, "1")
            R.id.nav_upcoming -> fetchMovies(MovieListSortingType.UPCOMING, "1")
            R.id.nav_now_playing -> fetchMovies(MovieListSortingType.NOW_PLAYING, "1")
            R.id.nav_revenue -> fetchMovies(MovieListSortingType.REVENUE, "1")
        }
        return true
    }
}
