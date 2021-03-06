package com.example.oldroy.greedyman.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.oldroy.greedyman.AddFriendFragment
import com.example.oldroy.greedyman.DashboardFragment
import com.example.oldroy.greedyman.FriendFragment

class CustomPagerAdapter(fm: FragmentManager?, val friendList: ArrayList<String>, val username: String) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return DashboardFragment()
            2 -> return FriendFragment.newInstance(username, friendList)
            3 -> return AddFriendFragment.newInstance(username)
            else -> return DashboardFragment()
        }
    }

    override fun getCount(): Int = 4

}