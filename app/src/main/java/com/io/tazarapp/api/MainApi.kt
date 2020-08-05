package com.io.tazarapp.api

import com.io.tazarapp.model.AuthResponseModel
import com.io.tazarapp.model.Makala
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MainApi {

    @FormUrlEncoded
    @POST("/api/v1/users/login/")
    suspend fun signIn(
        @Field("phone") phone: String,
        @Field("password") password: String
    ): Response<AuthResponseModel>

    @GET("api/title/")
    suspend fun getPartners(): Response<ArrayList<Makala>>

}