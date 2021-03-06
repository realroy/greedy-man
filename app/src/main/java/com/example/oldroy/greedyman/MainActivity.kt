package com.example.oldroy.greedyman

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.oldroy.greedyman.adapters.CustomPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var pagerAdapter: CustomPagerAdapter? = null

    fun onSuccessAdding() {
        container.setCurrentItem(0, true)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = intent.getStringExtra("USERNAME")
        val friends = intent.getStringArrayListExtra("FRIENDS")
        setSupportActionBar(toolbar)



        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        val text_username = nav_view.getHeaderView(0).findViewById(R.id.text_username) as TextView?
        text_username?.text = "Hello, $username"

        pagerAdapter = CustomPagerAdapter(supportFragmentManager, friends, username)
        container.adapter = pagerAdapter
        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))
        fab.setOnClickListener { view ->
            when (container.currentItem) {
                2 -> container.setCurrentItem(3, true)
            }
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_new_appointment -> {

            }
            R.id.nav_schedule -> {
                container.setCurrentItem(1, true)
            }
            R.id.nav_friend -> {
                container.setCurrentItem(2, true)
            }
            R.id.nav_add_friend -> {
                container.setCurrentItem(3, true)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
