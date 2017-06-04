package com.example.oldroy.greedyman

class LoginContact {

    interface View {
        fun onSubmit()
        fun onSuccessAuth()
        fun onErrorAuth()
    }

    interface Presenter {
        fun verifyAuth(username: String, password: String)
    }
}
