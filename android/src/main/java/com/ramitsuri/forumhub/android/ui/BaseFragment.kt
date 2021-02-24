package com.ramitsuri.forumhub.android.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ramitsuri.forumhub.android.util.Logger

class BaseFragment: Fragment() {
    private val TAG: String = this::class.java.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.i(TAG, "OnAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        Logger.i(TAG, "%s OnCreateView")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.i(TAG, "OnViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Logger.i(TAG, "OnViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        Logger.i(TAG, "OnAttach")
    }

    override fun onResume() {
        super.onResume()
        Logger.i(TAG, "OnResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Logger.i(TAG, "OnSaveInstanceState")
    }

    override fun onPause() {
        super.onPause()
        Logger.i(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Logger.i(TAG, "OnStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.i(TAG, "OnDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.i(TAG, "OnDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Logger.i(TAG, "OnDetach")
    }
}