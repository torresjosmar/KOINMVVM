package com.example.mvvmkoin.core.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val networtModule: Module = module{
    single { providerRetrofit() }
}

fun providerRetrofit(): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://a4aa071c-7938-42a8-994f-a47f0eac32bd.mock.pstmn.io/")
        .client(getLoggerInterceptor())
        .build()
}

fun getLoggerInterceptor(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    val httpClient = OkHttpClient.Builder()
    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    httpClient.addInterceptor(logging)
    return httpClient.build()
}
