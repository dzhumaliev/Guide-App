package com.io.tazarapp.ui.fragments.rating.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.io.tazarapp.R
import com.io.tazarapp.model.CompanyModel
import com.io.tazarapp.model.RateListModel
import kotlinx.android.synthetic.main.fragment_company.*

class CompanyFragment : Fragment() {

    //    private val viewModel: HistoryViewModel by viewModel()
    private lateinit var adapterCompany: CompanyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listeners()
        initRV()
    }

    private fun listeners() {

    }

    private fun initRV() {
        adapterCompany = CompanyAdapter()
        rv_outside_company.layoutManager = LinearLayoutManager(this.context)
        rv_outside_company.adapter = adapterCompany
        adapterCompany.update(updateData())

    }

    private fun updateData(): ArrayList<CompanyModel> {
        val list = ArrayList<CompanyModel>()
        val list2 = ArrayList<RateListModel>()
        list2.add(RateListModel(0, "1 место", "Саша", R.drawable.ic_img, "Бишкек", "500 кг"))
        list2.add(RateListModel(1, "2 место", "Маша", R.drawable.ic_img2, "Ош", "480 кг"))
        list2.add(RateListModel(2, "3 место", "Даша", R.drawable.ic_img2, "Каракол", "470 кг"))
        list2.add(RateListModel(3, "4 место", "Каша", R.drawable.ic_img, "Баткен", "460 кг"))
        list2.add(RateListModel(4, "5 место", "Яша", R.drawable.ic_img2, "Кадамжай", "450 кг"))
        val list3 = ArrayList<RateListModel>()
        list3.add(RateListModel(0, "1 место", "Абдулла", R.drawable.ic_img2, "Бишкек", "500 кг"))
        list3.add(RateListModel(1, "2 место", "Магомед", R.drawable.ic_img, "Ош", "480 кг"))
        list3.add(RateListModel(2, "3 место", "Ибрагим", R.drawable.ic_img2, "Каракол", "470 кг"))
        list3.add(RateListModel(3, "4 место", "Сулейман", R.drawable.ic_img2, "Баткен", "460 кг"))
        list3.add(RateListModel(4, "5 место", "Мехмет", R.drawable.ic_img, "Кадамжай", "450 кг"))
        val list4 = ArrayList<RateListModel>()
        list4.add(RateListModel(0, "1 место", "Улан", R.drawable.ic_img2, "Бишкек", "500 кг"))
        list4.add(RateListModel(1, "2 место", "Руслан", R.drawable.ic_img, "Ош", "480 кг"))
        list4.add(RateListModel(2, "3 место", "Самат", R.drawable.ic_img2, "Каракол", "470 кг"))
        list4.add(RateListModel(3, "4 место", "Азамат", R.drawable.ic_img, "Баткен", "460 кг"))
        list4.add(RateListModel(4, "5 место", "Бектемир", R.drawable.ic_img2, "Кадамжай", "450 кг"))

        list.add(
            CompanyModel(
                0,
                "Эко супергерои",
                R.drawable.ic_img,
                list2
            )
        )
        list.add(
            CompanyModel(
                1,
                "Генералы Эко",
                R.drawable.ic_img2,
                list3
            )
        )
        list.add(
            CompanyModel(
                2,
                "Титаны Эко",
                R.drawable.ic_img2,
                list4
            )
        )
        return list
    }


}
