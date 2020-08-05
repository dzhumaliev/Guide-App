package com.io.tazarapp.ui.login.auth

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.io.tazarapp.R
import com.io.tazarapp.ui.MainActivity
import com.io.tazarapp.ui.login.LoginActivity
import com.io.tazarapp.utils.PHONE_NUMBER
import com.io.tazarapp.utils.toast
import com.io.tazarapp.utils.visible
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_verification.*
import java.util.concurrent.TimeUnit


class VerificationActivity : AppCompatActivity(), TextWatcher {

//    private val viewModel: VerificationViewModel by viewModel()

    private var token: PhoneAuthProvider.OnVerificationStateChangedCallbacks? = null
    var smsInet: String? = null
    private var isCodeSent = false
    var code: String = ""
    var dialog: AlertDialog? = null
    var phoneNumber: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)
        init()
    }

    private fun requestOTP() {
        Log.e("token", token.toString())
        token = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                Log.e("Firebase verification", "onVerificationCompleted")
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.e("Firebase verification", "onVerificationCompleted" + e.message)
            }

            override fun onCodeSent(
                s: String,
                forceResendingToken: PhoneAuthProvider.ForceResendingToken
            ) {
                super.onCodeSent(s, forceResendingToken)
                isCodeSent = true
                smsInet = s
            }
        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            phoneNumber,
            60,
            TimeUnit.SECONDS,
            this,
            token!!
        )
    }

    private fun init() {
        dialog = SpotsDialog.Builder().setContext(this).setMessage(R.string.loading_message).build()
        phoneNumber = intent.getStringExtra(PHONE_NUMBER)
//        configureViewModel()
        setOnClickAction()
        numberSet(phoneNumber)
        timerStart()
        numb6.addTextChangedListener(this)
    }

    private fun setOnClickAction() {
        tv_send_again.setOnClickListener {
            requestOTP()
            timerStart()
        }
        btn_back3.setOnClickListener {
            finish()
        }
        wrong_number.setOnClickListener {
            startActivityLogin()
        }


        btnSend.setOnClickListener {
            code =
                numb1.text.toString() + numb2.text + numb3.text + numb4.text + numb5.text + numb6.text
            if (code.length == 6) {
                Log.e("code", code)
                val credential =
                    PhoneAuthProvider.getCredential(smsInet!!, code)
                signIn(credential)
            } else {
                toast("Введите 6-ти значный код")
            }
        }
    }

    private fun signIn(phoneAuthCredential: PhoneAuthCredential) {
        FirebaseAuth.getInstance()
            .signInWithCredential(phoneAuthCredential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    img_success.visible()
                    toast("Успешно")
                    startActivity(Intent(this, MainActivity::class.java))
//                    viewModel.signUp(phoneNumber)
                    Log.e("phoneNumber", phoneNumber)
                } else {
                    Log.e("TAG", "Ошибка авторизации")
                }
            }
    }

    private fun startActivityLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun numberSet(number: String) {
//        txt_number_verify.text = "${resources.getString(R.string.confirm)}  ${number}"
        wrong_number.text = "${number}"
    }

    private fun timerStart() {
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millis: Long) {
                tv_send_again.isClickable = false
                var seconds = (millis / 1000).toInt()
                val minutes = seconds / 60
                seconds %= 60
                timerTextView.text = "0" + String.format("%d:%02d", minutes, seconds) + " сек"
            }

            override fun onFinish() {
                timerTextView.text = ""
                tv_send_again.isClickable = true
            }
        }.start()
    }

    override fun onBackPressed() {
        this.toast("Подтвердите верификацию")
    }

    override fun afterTextChanged(p0: Editable?) {
        if (numb6.text.count() == 1) {
            btnSend.isClickable = true
            btnSend.background = resources.getDrawable(R.drawable.rounded_shape_primary)
        } else {
            btnSend.isClickable = false
            btnSend.background = resources.getDrawable(R.drawable.rounded_shape_silver)
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

//    private fun configureViewModel() {
//        requestOTP()
//        timerStart()
//
//        viewModel.loadingVisibility.observe(this, androidx.lifecycle.Observer {
//            if (it != null) {
//                val isSuccess = it.contentIfNotHandled
//                if (isSuccess != null)
//                    if (isSuccess) {
//                        dialog?.show()
//                    } else {
//                        dialog?.dismiss()
//                    }
//            }
//        })
//
//        viewModel.errorMessageLiveData.observe(
//            this,
//            androidx.lifecycle.Observer {
//                if (it != null) {
//                    val message = it.contentIfNotHandled
//                    if (message != null)
//                        toast(message)
//                }
//            })
//
//        viewModel.successCodeLiveData.observe(
//            this,
//            androidx.lifecycle.Observer {
//                if (it != null) {
//                    val isSuccess = it.contentIfNotHandled
//                    if (isSuccess != null)
//                        if (isSuccess == true) {
//                            val intent = Intent(this, ProfileActivity::class.java)
//                            startActivity(intent)
//                            finish()
//                        }
//                }
//            })
//    }
}
