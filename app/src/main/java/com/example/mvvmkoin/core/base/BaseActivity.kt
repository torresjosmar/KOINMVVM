package com.example.mvvmkoin.core.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.coderio.pocmvvmandroid.common.protocol.CommunicationCallback
import com.google.android.material.textfield.TextInputEditText
import java.lang.reflect.ParameterizedType

abstract class BaseActivity <T : ViewBinding> : AppCompatActivity(),CommunicationCallback {

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz = type.actualTypeArguments[0] as Class<*>
        val method = clazz.getMethod("inflate", LayoutInflater::class.java)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        binding = method.invoke(null, layoutInflater) as T
        setContentView(binding.root)
        init()
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {

        if (event!!.action == MotionEvent.ACTION_DOWN) {
            val view: View? = currentFocus
            if (view is TextInputEditText || view is EditText) {
                val outRect = Rect()
                view.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.x.toInt(), event.y.toInt())) {
                    view.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
                }
            }
        }

        return super.dispatchTouchEvent(event)
    }

    abstract fun init()

}
