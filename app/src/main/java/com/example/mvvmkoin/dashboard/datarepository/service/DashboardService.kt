package com.example.mvvmkoin.dashboard.datarepository.service

import com.coderio.pocmvvmandroid.registration.model.LoginRequestData
import com.coderio.pocmvvmandroid.registration.model.LoginResponseData
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface DashboardService {
    @POST("apimock/signin")
    fun login(@Body loginData: LoginRequestData): Single<LoginResponseData>
}