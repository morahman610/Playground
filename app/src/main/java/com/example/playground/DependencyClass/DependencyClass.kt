package com.example.playground.DependencyClass

import com.example.playground.Interface.DependencyInterface
import com.example.playground.Interface.DependencyInterfaceImp
import javax.inject.Inject
import kotlin.random.Random

class DependencyClass
@Inject
constructor(private val dependancyInterfaceImp: DependencyInterface) {

    fun getString() : String {
        return "From Dependency Class: " + dependancyInterfaceImp.doSomething()
    }

}