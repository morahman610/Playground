package com.example.playground.DI

import com.example.playground.DependencyClass.DependencyClass
import com.example.playground.Interface.DependencyInterface
import com.example.playground.Interface.DependencyInterfaceImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton
import kotlin.random.Random

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    @Named("Hello World")
    fun provideHelloWorldString() : String = "Hello World"

    @Singleton
    @Provides
    @Named("GoodBye World")
    fun provideGoodbyeWorldString() : String = "Goodbye World"

    @Singleton
    @Provides
    fun provideSomeStringDependency() : String {
        return "String Dependency"
    }

    @Singleton
    @Provides
    fun providedependencyInterface(interfaceImpString: String) : DependencyInterface {
        return DependencyInterfaceImp(interfaceImpString)
    }

    @Singleton
    @Provides
    fun provideGson() : Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun providedependencyClass(dependencyInterfaceImpl : DependencyInterface) : DependencyClass {
        return DependencyClass(dependencyInterfaceImpl)
    }
}