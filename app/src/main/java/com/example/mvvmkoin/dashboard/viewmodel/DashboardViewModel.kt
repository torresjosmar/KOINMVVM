package com.example.mvvmkoin.dashboard.viewmodel

import androidx.lifecycle.*
import com.example.mvvmkoin.core.base.BaseViewModel
import com.example.mvvmkoin.core.common.Outcome
import com.example.mvvmkoin.core.extensions.applySchedulers
import com.example.mvvmkoin.core.extensions.plusAssign
import com.example.mvvmkoin.dashboard.action.DashboardActions
import com.example.mvvmkoin.dashboard.domain.DashboardController
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel(private val dashboardController: DashboardController): BaseViewModel<DashboardViewModel>(){
    private val disposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        disposable.dispose()
    }

    fun loginUser(userName: String, password: String) {
        outcome.postValue(Outcome.loading(true))
        disposable += dashboardController.loginUser(userName, password)
            .applySchedulers()
            .subscribe({response ->
                outcome.postValue(Outcome.loading(false))
                //outcome.postValue(Outcome.success<DashboardActions>()))
            }, {
                outcome.postValue(Outcome.loading(false))
                outcome.postValue(Outcome.failure(it))
            })
    }

}