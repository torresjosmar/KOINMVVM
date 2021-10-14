package com.example.mvvmkoin.dashboard.view

import android.widget.Toast
import com.coderio.pocmvvmandroid.common.protocol.ProtocolAction
import com.example.mvvmkoin.core.base.BaseActivity
import com.example.mvvmkoin.databinding.MainActivityBinding
import java.time.Duration

class MainActivity : BaseActivity<MainActivityBinding>() {
    override fun init() {

    }


    //METODO PARA HACER CATCH DE LAS ACCIONES DEL COMUNICATION CALLBACK
    override fun onFragmentEvent(action: ProtocolAction) {
        when (action) {
            is ProtocolAction.OnEventName -> {
                Toast.makeText(this,action.value,Toast.LENGTH_LONG).show()
            }
            is ProtocolAction.OnConectionError -> {
                Toast.makeText(this,"Error de Red",Toast.LENGTH_LONG).show()
            }
        }
    }
}