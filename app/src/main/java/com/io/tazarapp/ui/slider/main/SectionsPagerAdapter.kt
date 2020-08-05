package com.io.tazarapp.ui.slider.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.io.tazarapp.ui.slider.main.Placeholder

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return Placeholder.newInstance(position + 1)
    }

    override fun getCount(): Int {
        return 3
    }
}