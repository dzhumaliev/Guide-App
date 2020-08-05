package com.io.tazarapp.ui.start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.io.tazarapp.R
import com.io.tazarapp.ui.slider.SliderActivity
import com.io.tazarapp.utils.LanguagePref
import kotlinx.android.synthetic.main.activity_language.*

class LanguageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme2)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        Glide.with(this).load(R.drawable.ic_world).into(image)
        listeners()
    }

    private fun listeners() {
        cl_en.setOnClickListener {
            LanguagePref(this).LanguageModule().saveLanguage("en")
            LocaleManager().updateResources(this, LanguagePref(this).LanguageModule().getLanguage())
            startActivity(Intent(this, SliderActivity::class.java))
            recreate()
        }
        cl_rus.setOnClickListener {
            LanguagePref(this).LanguageModule().saveLanguage("ru")
            LocaleManager().updateResources(this, LanguagePref(this).LanguageModule().getLanguage())
            startActivity(Intent(this, SliderActivity::class.java))
            recreate()
        }
    }
}