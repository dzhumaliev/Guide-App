package com.io.tazarapp.ui.login.signIn

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.io.tazarapp.R
import com.io.tazarapp.ui.login.auth.VerificationActivity
import com.io.tazarapp.utils.PHONE_NUMBER
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        listeners()
        et_auth.addTextChangedListener(this)

    }

    private fun listeners() {
        back_auth_back.setOnClickListener {
            finish()
        }

        btn_auth.setOnClickListener {
            if (et_auth.text.toString().isEmpty()) {
                Toast.makeText(this, "Введите номер телефона", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, VerificationActivity::class.java)
            intent.putExtra(PHONE_NUMBER, et_auth.text.toString())
            startActivity(intent)
        }
    }

    override fun afterTextChanged(p0: Editable?) {
        if (et_auth.text.toString().count() == 18) {
            btn_auth.isClickable = true
            btn_auth.background = resources.getDrawable(R.drawable.rounded_shape_primary)
        } else {
            btn_auth.isClickable = false
            btn_auth.background = resources.getDrawable(R.drawable.rounded_shape_silver)
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}
