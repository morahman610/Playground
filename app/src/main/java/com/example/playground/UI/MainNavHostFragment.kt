package com.example.playground.UI

import android.content.Context
import android.util.Log
import androidx.fragment.app.FragmentFactory
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainNavHostFragment : NavHostFragment() {

    private val TAG = "MainNavHostFragment"
    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.d(TAG, "Main Nav Host Fragment: onAttach")
        childFragmentManager.fragmentFactory = fragmentFactory
    }
}