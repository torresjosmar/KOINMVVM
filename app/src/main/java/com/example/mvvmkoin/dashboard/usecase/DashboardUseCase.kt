package com.example.mvvmkoin.dashboard.usecase

import com.coderio.pocmvvmandroid.registration.model.LoginRequestData
import com.example.mvvmkoin.dashboard.datarepository.repository.DashboardRepository

class DashboardUseCase(private val dashboardRepository: DashboardRepository) {

    private lateinit var dashboardModel:LoginRequestData

    fun bind(userName: String, password: String){
        dashboardModel = LoginRequestData(username = userName, password = password)
    }

    fun loginUser() = dashboardRepository.login(dashboardModel)

}