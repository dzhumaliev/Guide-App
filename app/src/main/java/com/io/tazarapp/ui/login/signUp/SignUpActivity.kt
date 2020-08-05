package com.io.tazarapp.ui.login.signUp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.io.tazarapp.R
import com.io.tazarapp.ui.login.auth.VerificationActivity
import com.io.tazarapp.utils.PHONE_NUMBER
import com.io.tazarapp.utils.toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), TextWatcher {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val id = intent?.getStringExtra("id")?.toInt()
        et_reg_info.addTextChangedListener(this)

        if (id == 1) {
            tv_title_info.text = "Регистрация как горожан"
        } else {
            tv_title_info.text = "Регистрация как переработчик"
        }
        listeners()
    }

    private fun listeners() {
        back_auth_info.setOnClickListener {
            finish()
        }

        btn_reg_info.setOnClickListener {
            if (et_reg_info.text.toString().isEmpty()) {
                toast("Введите номер телефона")
                return@setOnClickListener
            } else {
                val intent = Intent(this, VerificationActivity::class.java)
                intent.putExtra(PHONE_NUMBER, et_reg_info.text.toString())
                startActivity(intent)
            }
        }
    }

    override fun afterTextChanged(p0: Editable?) {
        if (et_reg_info.text.toString().count() == 18) {
            btn_reg_info.isClickable = true
            btn_reg_info.background = resources.getDrawable(R.drawable.rounded_shape_primary)
        } else {
            btn_reg_info.isClickable = false
            btn_reg_info.background = resources.getDrawable(R.drawable.rounded_shape_silver)
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }
}
