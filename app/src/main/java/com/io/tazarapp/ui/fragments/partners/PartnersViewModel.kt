package com.io.tazarapp.ui.fragments.partners

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.tazarapp.model.Makala
import com.io.tazarapp.ui.MainRepository
import kotlinx.coroutines.launch

class PartnersViewModel constructor(private val repo: MainRepository) : ViewModel() {
    var redate: MutableLiveData<ArrayList<Makala>> = MutableLiveData()

    fun getPartners() {
        viewModelScope.launch {
            val response = repo.getPartners()
            if (response != null) {
                if (response.isSuccessful) {
                    redate.value = response.body()
                }
            }
        }

    }
}