package com.io.tazarapp.ui.fragments.rating

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.io.tazarapp.R
import kotlinx.android.synthetic.main.fragment_rating.*

class RatingFragment : Fragment() {

    var sectionsPagerAdapter: CBSPAdapterTab? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        sectionsPagerAdapter = activity?.let {
            CBSPAdapterTab(it, childFragmentManager)
        }
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

    }

}
