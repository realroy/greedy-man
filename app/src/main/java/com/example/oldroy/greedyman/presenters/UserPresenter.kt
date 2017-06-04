package com.example.oldroy.greedyman.presenters

import com.example.oldroy.greedyman.contacts.UserContact
import com.example.oldroy.greedyman.models.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class UserPresenter(private val view: UserContact.View) : UserContact.Presenter {

    private val userRef = FirebaseDatabase.getInstance().getReference("users")

    override fun createNewAccount(user: User) {
        userRef.child(user.name).setValue(user)
    }

    override fun verifyAuth(username: String, password: String) {
        userRef.child(username).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) = view.onError()
            override fun onDataChange(snapshot: DataSnapshot?) {
                val user = snapshot?.getValue(User::class.java)
                if (user?.password == password) return view.onSuccess(user)
                view.onError()
            }
        })
    }


}