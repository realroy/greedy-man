package com.example.oldroy.greedyman.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.oldroy.greedyman.DashboardFragment
import com.example.oldroy.greedyman.FriendFragment

class CustomPagerAdapter(fm: FragmentManager?, val friendList: ArrayList<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return DashboardFragment()
            2 -> return FriendFragment.newInstance(friendList)
            else -> return DashboardFragment()
        }
    }

    override fun getCount(): Int = 3

}