package com.example.playground.DI

import com.example.playground.DependencyClass.DependencyClass
import com.example.playground.Interface.DependencyInterface
import com.example.playground.Interface.DependencyInterfaceImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton
import kotlin.random.Random

@Module
@InstallIn(FragmentComponent::class)
object AppModule {

    @HelloWorld
    @FragmentScoped
    @Provides
    fun provideHelloWorldString() : String = "Hello World"

    @FragmentScoped
    @Provides
    @Named("GoodBye World")
    fun provideGoodbyeWorldString() : String = "Goodbye World"

    @FragmentScoped
    @Provides
    fun provideSomeStringDependency() : String {
        return "String Dependency"
    }

    @FragmentScoped
    @Provides
    fun providedependencyInterface(interfaceImpString: String) : DependencyInterface {
        return DependencyInterfaceImp(interfaceImpString)
    }

    @FragmentScoped
    @Provides
    fun provideGson() : Gson {
        return Gson()
    }

    @FragmentScoped
    @Provides
    fun providedependencyClass(dependencyInterfaceImpl : DependencyInterface) : DependencyClass {
        return DependencyClass(dependencyInterfaceImpl)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HelloWorld
