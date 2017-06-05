package com.example.oldroy.greedyman

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CustomPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return DashboardFragment()
            else -> return DashboardFragment()
        }
    }

    override fun getCount(): Int = 3

}