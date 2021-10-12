package com.example.mvvmkoin.dashboard.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.example.mvvmkoin.R
import com.example.mvvmkoin.dashboard.viewmodel.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.example.mvvmkoin.core.common.Outcome
import com.example.mvvmkoin.dashboard.action.DashboardActions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){

    }
}