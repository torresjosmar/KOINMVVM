package com.example.mvvmkoin.core.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmkoin.core.common.Outcome
import com.example.mvvmkoin.dashboard.action.DashboardActions

abstract class BaseViewModel<T> : ViewModel(),LifecycleObserver {
    val outcome by lazy { MutableLiveData<Outcome<T>>() }

}