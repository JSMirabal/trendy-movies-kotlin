package com.japps.trendymovieskotlin.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import android.widget.Toast
import com.japps.trendymovieskotlin.decoration.ItemOffsetDecoration
import com.japps.trendymovieskotlin.adapter.MainRecyclerAdapter
import com.japps.trendymovieskotlin.R
import com.japps.trendymovieskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mAdapter: MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupRecycler()
    }

    private fun setupRecycler() {
        mAdapter = MainRecyclerAdapter()
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
            R.id.nav_trending -> Toast.makeText(this, "Trending", Toast.LENGTH_SHORT).show()
            R.id.nav_top_rated -> Toast.makeText(this, "Top Rated", Toast.LENGTH_SHORT).show()
            R.id.nav_upcoming -> Toast.makeText(this, "Upcoming", Toast.LENGTH_SHORT).show()
            R.id.nav_now_playing -> Toast.makeText(this, "Now Playing", Toast.LENGTH_SHORT).show()
            R.id.nav_revenue -> Toast.makeText(this, "Revenue", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
