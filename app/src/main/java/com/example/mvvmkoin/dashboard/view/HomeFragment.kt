package com.example.mvvmkoin.dashboard.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvmkoin.R
import com.example.mvvmkoin.core.common.Outcome
import com.example.mvvmkoin.dashboard.action.DashboardActions
import com.example.mvvmkoin.dashboard.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {
    private val viewModel: DashboardViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenToObserver()
        init()
    }

    private fun init(){
        btnRun.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            viewModel.loginUser("prueba","prueba")
        }

    }

    private fun listenToObserver() {
        viewModel.outcome.observe(requireActivity(), Observer {outcome ->
            progressBar.visibility = View.GONE
            when(outcome){
                is Outcome.Success -> onSuccess(outcome.data)
                is Outcome.Failure -> onError(outcome.e)
                else -> { }
            }
        })
    }

    private fun onSuccess(data: DashboardActions) {
        when (data) {
            is DashboardActions.OnLoginResponse -> {
                Toast.makeText(requireContext(), data.token, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onError(error: Throwable) {
        error.printStackTrace()
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }

}