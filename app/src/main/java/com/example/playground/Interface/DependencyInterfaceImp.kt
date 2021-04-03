package com.example.playground.Interface

import javax.inject.Inject

class DependencyInterfaceImp
@Inject constructor(private val interfaceImpString : String) : DependencyInterface {
    override fun doSomething(): String {
        return "DependencyInterfaceImp : Do Something Function. ${interfaceImpString}"
    }
}