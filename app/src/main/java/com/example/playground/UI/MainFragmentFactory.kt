package com.example.playground.UI

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.playground.DependencyClass.DependencyClass
import com.example.playground.Interface.DependencyInterface
import javax.inject.Inject
import javax.inject.Named

class MainFragmentFactory
    @Inject
    constructor(
        @Named("Hello World")
        private val helloWorld : String,
        @Named("GoodBye World")
        private val goodByeWorld : String,
        private val dependencyClass: DependencyClass,
        private val dependencyInterfaceImp: DependencyInterface

    ) : FragmentFactory(){

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when(className) {

            MainFragment::class.java.name -> { MainFragment(helloWorld, goodByeWorld,
                dependencyInterfaceImp, dependencyClass) }

            else -> super.instantiate(classLoader, className)
        }
    }
}