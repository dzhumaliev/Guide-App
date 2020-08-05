package com.io.tazarapp.ui


import com.io.tazarapp.api.MainApi
import com.io.tazarapp.model.AuthResponseModel
import com.io.tazarapp.model.Makala
import retrofit2.Response

class MainRepository(private var api: MainApi) {

    suspend fun getAuthUser(phoneNumber: String, pass: String): Response<AuthResponseModel>? {
        return try {
            api.signIn(phoneNumber, pass)
        } catch (e: Exception) {
            null
        }
    }


    suspend fun getPartners(): Response<ArrayList<Makala>>? {
        return api.getPartners()
    }
}