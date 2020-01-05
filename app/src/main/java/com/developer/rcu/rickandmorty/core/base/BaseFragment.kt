package com.developer.rcu.rickandmorty.core.base

import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.developer.rcu.rickandmorty.AndroidApplication
import com.developer.rcu.rickandmorty.core.di.ApplicationComponent
import com.developer.rcu.rickandmorty.view.MainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by Raul Corvo on 27/11/2018
 */
abstract class BaseFragment : androidx.fragment.app.Fragment() {

    abstract fun layoutId(): Int

    private var snackbar: Snackbar? = null

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (activity?.application as AndroidApplication).appComponent
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

    internal fun showProgress(message: Int) {
        progressStatus(View.VISIBLE)
        notify(message)
    }

    internal fun hideProgress() {
        progressStatus(View.GONE)
        snackbar?.dismiss()
    }

    internal fun showToolBar() {
        toolBar(View.VISIBLE)
    }

    internal fun hideToolBar() {
        toolBar(View.GONE)
    }

    private fun progressStatus(viewStatus: Int) =
        with(activity) {
            if (this is MainActivity) {
                this.progress.visibility = viewStatus
            }
        }

    private fun toolBar(viewStatus: Int) =
        with(activity) {
            if (this is MainActivity) {
                this.toolbar.visibility = viewStatus
            }
        }

    private fun notify(@StringRes message: Int) =
        this.view?.let { view ->
            snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
            snackbar?.show()
        }

    internal fun notifyWithAction(@StringRes message: Int, @StringRes actionText: Int, action: () -> Any) =
        this.view?.let { view ->
            val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction(actionText) { action.invoke() }
            snackbar.show()
            hideProgress()
        }
}