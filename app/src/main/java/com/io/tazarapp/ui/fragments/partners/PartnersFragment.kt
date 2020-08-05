package com.io.tazarapp.ui.fragments.partners

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.io.tazarapp.R
import com.io.tazarapp.model.Makala
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class PartnersFragment : Fragment() {

    private lateinit var adapterPartners: PartnersAdapter
    private val viewModel: PartnersViewModel by viewModel()
    private var recyclerPartners: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_partners, container, false)
        partnersInit(view)
        return view
    }

    private fun partnersInit(view: View) {
        recyclerPartners = view.findViewById(R.id.recycler_main_item)
        adapterPartners =
            PartnersAdapter { item: Makala ->
                clickItemMain(item)
            }
        recyclerPartners?.layoutManager =
            LinearLayoutManager(this.context)
        recyclerPartners?.adapter = adapterPartners
        viewModel.getPartners()
        viewModel.redate.observe(viewLifecycleOwner, Observer {
            if (it == null) {
                Log.e("Empty", "Item class is empty")
            } else {
                adapterPartners.update(it)
            }
        })
    }

    private fun clickItemMain(itemView: Makala) {
        val intent = Intent(context, PartnersInfoActivity::class.java)
        intent.putExtra("idPartners", itemView.id.toString())
        intent.putExtra("img", itemView.icon)
        intent.putExtra("title", itemView.title)
        intent.putExtra("category", itemView.category)
        startActivity(intent)
    }

}
