package com.example.mvvmkoin.dashboard.datarepository.repository

import com.coderio.pocmvvmandroid.registration.model.LoginRequestData
import com.example.mvvmkoin.dashboard.datarepository.service.DashboardService

class DashboardRepository(private val dashboardService: DashboardService) {
    fun login(loginData: LoginRequestData) = dashboardService.login(loginData)
}