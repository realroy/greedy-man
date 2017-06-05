package com.example.oldroy.greedyman


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oldroy.greedyman.adapters.FriendAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FriendFragment : Fragment() {

    private var friendAdapter: FriendAdapter? = null
    private var friendList = ArrayList<String>()

    companion object {
        val ARG_FRIEND_LIST: String = "friend list"
        val ARG_USERNAME: String = "username"

        fun newInstance(username: String, friendList: ArrayList<String>): Fragment {
            val fragment = FriendFragment()
            val arg = Bundle()
            arg.putString(FriendFragment.ARG_USERNAME, username)
            arg.putStringArrayList(FriendFragment.ARG_FRIEND_LIST, friendList)
            fragment.arguments = arg
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_friend, container, false)
        val recycler_friend = view.findViewById(R.id.recycler_friend) as RecyclerView
        friendList.addAll(arguments.get(FriendFragment.ARG_FRIEND_LIST) as ArrayList<String>)
        friendAdapter = FriendAdapter(friendList, context)
        recycler_friend.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_friend.adapter = friendAdapter
        val username = arguments.get(FriendFragment.ARG_USERNAME) as String
        FirebaseDatabase
                .getInstance()
                .getReference("users")
                .child(username)
                .child("friends")
                .addValueEventListener(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onDataChange(snapshot: DataSnapshot?) = updateDate(snapshot!!)
                })
        return view
    }

    private fun updateDate(snapshot: DataSnapshot) {
        friendList.clear()
        snapshot.children?.forEach { each -> friendList.add(each.value as String) }
        friendAdapter?.notifyDataSetChanged()
    }

}