package com.example.oldroy.greedyman


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AddFriendFragment : Fragment() {

    companion object {
        val ARG_USERNAME: String = "username"

        fun newInstance(username: String): Fragment {
            val fragment = AddFriendFragment()
            val arg = Bundle()
            arg.putString(AddFriendFragment.ARG_USERNAME, username)
            fragment.arguments = arg
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_add_friend, container, false)
        val button_add_friend = view.findViewById(R.id.button_add_friend) as Button
        val text_username = view.findViewById(R.id.text_username) as EditText
        button_add_friend.setOnClickListener { onSubmit(text_username.text.toString()) }

        return view
    }

    fun onSubmit(friendName: String) {
        val userRef = FirebaseDatabase.getInstance().getReference("users")
        userRef.child(friendName).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot?) {
                val username = arguments.getString(AddFriendFragment.ARG_USERNAME)
                if (p0?.hasChildren() as Boolean) {
                    userRef.child(username).child("friends").setValue(friendName)
                    Toast.makeText(context, "$friendName is added to your friend list!", Toast.LENGTH_SHORT).show()
                    val ctx = context as MainActivity
                    ctx.onSuccessAdding()
                }
            }

        })
    }

}
