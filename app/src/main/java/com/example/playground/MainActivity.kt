package com.example.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.playground.DependencyClass.DependencyClass
import com.example.playground.Interface.DependencyInterface
import com.example.playground.Interface.DependencyInterfaceImp
import com.example.playground.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    
    @Inject
    @Named("Hello World")
    lateinit var helloWorld: String

    @Inject
    @Named("GoodBye World")
    lateinit var goodByeWorld : String

    @Inject
    lateinit var dependencyInterfaceImp: DependencyInterface

    @Inject
    lateinit var dependencyClass: DependencyClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

    override fun onStart() {
        super.onStart()
        binding.helloWorld.text = helloWorld
        binding.goodByeWorld.text = goodByeWorld
        binding.dependencyInterfaceTxt.text = dependencyInterfaceImp.doSomething()
        binding.dependencyClassTxt.text = dependencyClass.getString()
    }
}