package com.example.oldroy.greedyman


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oldroy.greedyman.adapters.FriendAdapter


class FriendFragment : Fragment() {

    companion object {
        val ARG_FRIEND_LIST: String = "friend list"
        fun newInstance(friendList: ArrayList<String>): Fragment {
            val fragment = FriendFragment()
            val arg = Bundle()
            arg.putStringArrayList(FriendFragment.ARG_FRIEND_LIST, friendList)
            fragment.arguments = arg
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_friend, container, false)
        val recycler_friend = view.findViewById(R.id.recycler_friend) as RecyclerView
        val friendList = arguments.get(FriendFragment.ARG_FRIEND_LIST) as ArrayList<String>
        val friendAdapter = FriendAdapter(friendList, context)
        recycler_friend.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_friend.adapter = friendAdapter
        return view
    }

}