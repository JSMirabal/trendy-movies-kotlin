package com.japps.trendymovieskotlin

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import com.japps.trendymovieskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        binding.bottomNavigation.menu.findItem(R.id.nav_trending).isChecked = true
        binding.executePendingBindings()
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
