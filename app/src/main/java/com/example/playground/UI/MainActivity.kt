package com.example.playground.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.playground.DependencyClass.DependencyClass
import com.example.playground.Interface.DependencyInterface
import com.example.playground.Interface.DependencyInterfaceImp
import com.example.playground.R
import com.example.playground.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.fragmentFactory = fragmentFactory
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, MainFragment::class.java, null)
            .commit()
    }
}