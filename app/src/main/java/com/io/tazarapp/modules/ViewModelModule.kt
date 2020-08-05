package com.io.tazarapp.modules


import com.io.tazarapp.ui.fragments.partners.PartnersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { PartnersViewModel(get()) }

}