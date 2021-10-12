package com.example.mvvmkoin.dashboard.repository

import com.coderio.pocmvvmandroid.registration.model.LoginRequestData
import com.example.mvvmkoin.dashboard.service.DashboardService

class DashboardRepository(private val dashboardService: DashboardService) {
    fun login(loginData: LoginRequestData) = dashboardService.login(loginData)
}