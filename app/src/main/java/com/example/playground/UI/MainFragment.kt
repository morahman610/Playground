package com.example.playground.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.playground.DI.HelloWorld
import com.example.playground.DependencyClass.DependencyClass
import com.example.playground.Interface.DependencyInterface
import com.example.playground.Interface.DependencyInterfaceImp
import com.example.playground.R
import com.example.playground.databinding.FragmentMainBinding
import javax.inject.Inject
import javax.inject.Named

class MainFragment
    // PR Template Change
    //Check Change
    constructor(
        @HelloWorld
        private val helloWorld : String,
        @Named("Goodbye World")
        private val goodByeWorld : String,
        private val dependencyInterfaceImp: DependencyInterface,
        private val dependencyClass: DependencyClass

    ): Fragment(R.layout.fragment_main) {

    private val TAG = "MainFragment"

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d(TAG, "Main Fragment: onViewCreated")

        binding.helloWorld.text = helloWorld
        binding.goodByeWorld.text = goodByeWorld
        binding.dependencyInterfaceTxt.text = dependencyInterfaceImp.doSomething()
        binding.dependencyClassTxt.text = dependencyClass.getString()
        binding.composeBtn.setOnClickListener {
            findNavController().navigate(R.id.mainToCompose)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}