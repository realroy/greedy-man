package com.example.oldroy.greedyman

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContact.View {


    private var loginPresenter: LoginContact.Presenter? = null

    override fun onSuccessAuth() {
        login_progress.visibility = ProgressBar.GONE
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun onErrorAuth() {
        login_progress.visibility = ProgressBar.GONE
        Toast.makeText(this, "Wrong password or username!", Toast.LENGTH_LONG).show()
    }

    override fun onSubmit() {
        val username = text_username.text.toString()
        val password = text_password.text.toString()
        if (username == "" || password == "") {
            return Toast.makeText(this, "Username and password shouldn't be empty!", Toast.LENGTH_LONG).show()
        }
        login_progress.visibility = ProgressBar.VISIBLE
        loginPresenter?.verifyAuth(username, password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this)
        button_sign_in.setOnClickListener { onSubmit() }
    }

}

