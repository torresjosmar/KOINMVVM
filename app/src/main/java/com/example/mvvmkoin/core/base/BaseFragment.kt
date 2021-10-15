package com.example.mvvmkoin.core.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.coderio.pocmvvmandroid.common.protocol.CommunicationCallback
import com.coderio.pocmvvmandroid.common.protocol.ProtocolAction
import com.example.mvvmkoin.dashboard.action.DashboardActions
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<T : ViewBinding>: Fragment() {

    lateinit var bindingView: T
    private var activity: BaseActivity<*>? = null
    protected var TAG_SCREEN: String? = null
    lateinit var communication: CommunicationCallback



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communication = (requireActivity() as BaseActivity<*>)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz = type.actualTypeArguments[0] as Class<*>
        val method = clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        bindingView = method.invoke(null, layoutInflater, container, false) as T
        TAG_SCREEN = "[" + javaClass.simpleName + "]"
        Log.i("SCREEN", "*********************")
        Log.i("SCREEN", TAG_SCREEN!!)
        Log.i("SCREEN", "*********************")
        return bindingView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as BaseActivity<*>
    }

    override fun onDetach() {
        super.onDetach()
        activity = null
    }


    abstract fun init()

    protected abstract fun screenName(): String

    abstract fun onLoading(loading: Boolean)

    abstract fun  listenToObserver()

    //Capturar todos los errores cross
    fun onError(e: Any) {
        //ejemplo de evento de falla de conexion
        communication.onFragmentEvent(ProtocolAction.OnConectionError)
    }

}