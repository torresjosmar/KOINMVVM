package com.example.mvvmkoin.dashboard.action

sealed class DashboardActions {
    class OnLoginResponse(val token: String): DashboardActions()
}