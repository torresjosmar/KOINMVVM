package com.example.mvvmkoin.dashboard.view

import androidx.core.view.isVisible
import com.coderio.pocmvvmandroid.common.protocol.ProtocolAction
import com.example.mvvmkoin.core.base.BaseFragment
import com.example.mvvmkoin.dashboard.action.DashboardActions
import com.example.mvvmkoin.dashboard.viewmodel.DashboardViewModel
import com.example.mvvmkoin.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*


class HomeFragment : BaseFragment<HomeFragmentBinding,DashboardViewModel>() {
    //val viewModel : DashboardViewModel by viewModel()

    override fun init() {
        setClickListeners()
    }

    override fun screenName(): String = "Home"

    private fun setClickListeners(){
        btnRun.setOnClickListener {
            (viewModel as DashboardViewModel).loginUser("prueba","prueba")
        }
    }



    override fun onSuccess(data: DashboardViewModel) {
        when(data){
            /*is DashboardActions.OnLoginResponse -> {
                communication.onFragmentEvent(ProtocolAction.OnEventName(data.token))
            }*/
        }
    }

    //este metodo se puede agregar tambien al base fragment queda por definir
    override fun onLoading(loading: Boolean) {
        progressBar.isVisible = loading
    }

}