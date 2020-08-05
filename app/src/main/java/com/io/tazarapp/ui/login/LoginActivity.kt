package com.io.tazarapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.io.tazarapp.R
import com.io.tazarapp.ui.MainActivity
import com.io.tazarapp.ui.login.signIn.SignInActivity
import com.io.tazarapp.ui.login.signUp.RegistrationActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        listener()
    }

    private fun listener() {
        btn_registration.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
        btn_auth.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        btn_menu.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}
