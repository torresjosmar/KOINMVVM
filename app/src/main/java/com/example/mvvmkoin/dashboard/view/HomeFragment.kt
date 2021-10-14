package com.example.mvvmkoin.dashboard.view

import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.coderio.pocmvvmandroid.common.protocol.ProtocolAction
import com.example.mvvmkoin.core.base.BaseFragment
import com.example.mvvmkoin.core.common.Outcome
import com.example.mvvmkoin.dashboard.action.DashboardActions
import com.example.mvvmkoin.dashboard.viewmodel.DashboardViewModel
import com.example.mvvmkoin.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    val viewModel : DashboardViewModel by viewModel()

    override fun init() {
        listenToObserver()
        setClickListeners()
    }

    override fun screenName(): String = "Home"

    private fun setClickListeners(){
        btnRun.setOnClickListener {
            (viewModel as DashboardViewModel).loginUser("prueba","prueba")
        }
    }

    private fun listenToObserver() {
        viewModel.outcome.observe(this, Observer {outcome ->
            when(outcome){
                is Outcome.Success -> onSuccess(outcome.data)
                is Outcome.Failure -> onError(outcome.e)
                is Outcome.Progress -> onLoading(outcome.loading)
                else -> { }
            }
        })
    }

    override fun onSuccess(data: DashboardActions) {
        when(data){
            is DashboardActions.OnLoginResponse -> {
                communication.onFragmentEvent(ProtocolAction.OnEventName(data.token))
            }
        }
    }

    //este metodo se puede agregar tambien al base fragment queda por definir
    override fun onLoading(loading: Boolean) {
        progressBar.isVisible = loading
    }

}