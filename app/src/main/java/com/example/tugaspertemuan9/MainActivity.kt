package com.example.tugaspertemuan9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tugaspertemuan9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        title = "TravelApp"
        setContentView(binding.root)
        with(binding){
            val navController = findNavController(R.id.Main_host_fragment)
            MainBottomNavigation.setupWithNavController(navController)


        }


    }


}