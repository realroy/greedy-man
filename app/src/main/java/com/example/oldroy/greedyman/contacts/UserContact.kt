package com.example.oldroy.greedyman.contacts

import com.example.oldroy.greedyman.models.User

class UserContact {

    interface View {
        fun onSubmit()
        fun onSuccess(user: User)
        fun onError()
    }

    interface Presenter {
        fun createNewAccount(user: User)
        fun verifyAuth(username: String, password: String)
    }
}
