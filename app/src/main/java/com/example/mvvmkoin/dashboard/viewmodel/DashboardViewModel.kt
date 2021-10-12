package com.example.mvvmkoin.dashboard.viewmodel

import androidx.lifecycle.*
import com.example.mvvmkoin.core.common.Outcome
import com.example.mvvmkoin.core.extensions.applySchedulers
import com.example.mvvmkoin.core.extensions.plusAssign
import com.example.mvvmkoin.dashboard.action.DashboardActions
import com.example.mvvmkoin.dashboard.controller.DashboardController
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel(private val dashboardController: DashboardController) : ViewModel(), LifecycleObserver {
    val outcome by lazy { MutableLiveData<Outcome<DashboardActions>>() }
    private val disposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        disposable.dispose()
    }

    fun loginUser(userName: String, password: String) {
        disposable += dashboardController.loginUser(userName, password)
            .applySchedulers()
            .subscribe({response ->
                outcome.postValue(Outcome.success(DashboardActions.OnLoginResponse(response.token)))
            }, {
                outcome.postValue(Outcome.failure(it))
            })
    }

}