package com.example.oldroy.greedyman

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast
import com.example.oldroy.greedyman.contacts.UserContact
import com.example.oldroy.greedyman.models.User
import com.example.oldroy.greedyman.presenters.UserPresenter
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), UserContact.View {


    private var userPresenter: UserContact.Presenter? = null

    override fun onSuccess(user: User) {
        login_progress.visibility = ProgressBar.GONE
        val intent: Intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("USER", user)
        startActivity(intent)
        finish()
    }

    override fun onError() {
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
        userPresenter?.verifyAuth(username, password)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        userPresenter = UserPresenter(this)
        button_sign_in.setOnClickListener { onSubmit() }
    }

}

