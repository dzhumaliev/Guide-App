package com.io.tazarapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.io.tazarapp.R
import com.io.tazarapp.ui.fragments.partners.PartnersFragment
import com.io.tazarapp.ui.fragments.rating.RatingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(PartnersFragment())
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.main -> {
                    title = resources.getString(R.string.main)
                    loadFragment(PartnersFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.time -> {
                    title = resources.getString(R.string.top)
                    loadFragment(RatingFragment())
                    return@setOnNavigationItemSelectedListener true
                }
//
//                R.id.today -> {
//                    title = resources.getString(R.string.today)
//                    loadFragment(TodayFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.about -> {
//                    title = resources.getString(R.string.about)
//                    loadFragment(AboutFragment())
//                    return@setOnNavigationItemSelectedListener true
//                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
