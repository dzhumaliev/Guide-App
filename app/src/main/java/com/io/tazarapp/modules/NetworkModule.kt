package com.io.tazarapp.modules

import com.io.tazarapp.App
import com.io.tazarapp.BuildConfig
import com.io.tazarapp.utils.SharedPrefModule
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private val sLogLevel =
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

private const val baseUrl = "http://149.154.69.18/"

fun createNetworkClient() = retrofitClient(
    baseUrl,
    okHttpClient(true)
)

private fun getLogInterceptor() = HttpLoggingInterceptor().apply { level = sLogLevel }

private fun okHttpClient(addAuthHeader: Boolean) = OkHttpClient.Builder()
    .addInterceptor(getLogInterceptor()).apply {
        setTimeOutToOkHttpClient(
            this
        )
    }
    .addInterceptor(headersInterceptor(addAuthHeader)).build()

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
//        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()

fun headersInterceptor(addAuthHeader: Boolean) = Interceptor { chain ->
    chain.proceed(
        chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .also {
                if (addAuthHeader) {
//                    Log.e("HEADER", SharedPrefModule(App.context).TokenModule().getToken()?.token + "")
                    if (SharedPrefModule(App.context).TokenModule().getToken() != null) {
                        it.addHeader(
                            "Authorization",
                            "Token " + SharedPrefModule(App.context).TokenModule().getToken()?.token
                        )
                    }
                }
            }
            .build()
    )
}

private fun setTimeOutToOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder) =
    okHttpClientBuilder.apply {
        readTimeout(30L, TimeUnit.SECONDS)
        connectTimeout(30L, TimeUnit.SECONDS)
        writeTimeout(30L, TimeUnit.SECONDS)
    }