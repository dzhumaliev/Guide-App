package com.io.tazarapp.modules

import com.io.tazarapp.ui.MainRepository
import org.koin.dsl.module


val repositoryModule = module {

    single { MainRepository(get()) }
}