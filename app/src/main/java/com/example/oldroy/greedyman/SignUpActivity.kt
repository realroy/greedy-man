package com.example.oldroy.greedyman

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast
import com.example.oldroy.greedyman.contacts.UserContact
import com.example.oldroy.greedyman.models.User
import com.example.oldroy.greedyman.presenters.UserPresenter
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), UserContact.View {

    private var userPresenter: UserContact.Presenter? = null

    override fun onSubmit() {
        val username = text_username.text.toString()
        val password = text_password.text.toString()
        if (username == "" || password == "") {
            return Toast.makeText(this, "Username and password shouldn't be empty!", Toast.LENGTH_LONG).show()
        }
        val user = User()
        user.name = username
        user.password = password
        login_progress.visibility = ProgressBar.VISIBLE
        userPresenter?.createNewAccount(user)
    }

    override fun onSuccess(user: User) {
        login_progress.visibility = ProgressBar.GONE
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("USERNAME", user.name)
        intent.putExtra("FRIENDS", user.friends)
        startActivity(intent)
        finish()
    }

    override fun onError() {
        login_progress.visibility = ProgressBar.GONE
        return Toast.makeText(this, "Username already existed, Please change username!", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        userPresenter = UserPresenter(this)
        button_sign_up.setOnClickListener { onSubmit() }
    }
}
