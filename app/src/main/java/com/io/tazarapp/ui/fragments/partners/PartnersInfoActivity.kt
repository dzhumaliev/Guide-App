package com.io.tazarapp.ui.fragments.partners

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.io.tazarapp.R
import kotlinx.android.synthetic.main.activity_partners_info.*

class PartnersInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partners_info)
        listeners()
        getter()
    }

    private fun listeners() {
        back_part.setOnClickListener {
            finish()
        }
    }

    private fun getter() {
        val ids = intent.getStringExtra("idPartners")
        val img = intent.getStringExtra("img")
        val title = intent.getStringExtra("title")
        val category = intent.getStringExtra("category")

        Glide.with(this).load(R.drawable.ic_icon_question).into(image_partners_info)
        title_partners_info.text = title
    }
}
