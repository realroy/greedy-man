package com.example.oldroy.greedyman.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.oldroy.greedyman.R
import kotlinx.android.synthetic.main.card_friend.view.*

class FriendAdapter(private val friendList: ArrayList<String>, private val context: Context) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) = viewHolder!!.bindData(friendList[position])

    override fun getItemCount(): Int = friendList.size

    override fun onCreateViewHolder(viewGroup: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.card_friend, viewGroup, false)
        return ViewHolder(view, context)
    }

    class ViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
        fun bindData(username: String) {
            itemView.text_username.text = username
        }
    }
}