package com.io.tazarapp.modules

import com.io.tazarapp.api.MainApi
import org.koin.dsl.module
import retrofit2.Retrofit


private val retrofit: Retrofit =
    createNetworkClient()

private val REST_API: MainApi = retrofit.create(MainApi::class.java)

val networkModule = module {
    single { REST_API }
}