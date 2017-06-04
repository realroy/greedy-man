package com.example.oldroy.greedyman

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginPresenter(private val view: LoginContact.View) : LoginContact.Presenter {

    override fun verifyAuth(username: String, password: String) {
        FirebaseDatabase.getInstance()
                .getReference("users")
                .child(username)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onDataChange(snapshot: DataSnapshot?) {
                        val user = snapshot?.getValue(User::class.java)
                        if (user?.password == password) {
                            Log.d(">>>>>>>>>>", "${user.password}, $password")
                            return view.onSuccessAuth()
                        }
                        view.onErrorAuth()
                    }
                })
    }

}