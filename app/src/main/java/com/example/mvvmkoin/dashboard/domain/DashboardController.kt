package com.example.mvvmkoin.dashboard.domain

import com.coderio.pocmvvmandroid.registration.model.LoginRequestData
import com.example.mvvmkoin.dashboard.datarepository.repository.DashboardRepository

class DashboardController(private val dashboardRepository: DashboardRepository) {

    fun loginUser(userName: String, password: String) =
        dashboardRepository.login(LoginRequestData(userName, password))

}