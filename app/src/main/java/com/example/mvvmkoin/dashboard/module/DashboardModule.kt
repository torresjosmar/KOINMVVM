package com.example.mvvmkoin.dashboard.module

import com.example.mvvmkoin.dashboard.usecase.DashboardUseCase
import com.example.mvvmkoin.dashboard.datarepository.repository.DashboardRepository
import com.example.mvvmkoin.dashboard.datarepository.service.DashboardService
import com.example.mvvmkoin.dashboard.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit

val dashboardModule: Module = module {
   viewModel {
      DashboardViewModel(dashboardUseCase = get())
   }
   single { DashboardUseCase(dashboardRepository = get()) }
   single { DashboardRepository(dashboardService = get()) }
   single { providerUsersService(get()) }

}

fun providerUsersService(retrofit: Retrofit): DashboardService{
   return retrofit.create(DashboardService::class.java)
}