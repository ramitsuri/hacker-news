package com.ramitsuri.forumhub.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.ramitsuri.forumhub.android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpNavigation()
        setFullScreen()
    }

    private fun setUpNavigation() {
        /* val bottomNavigationView = binding.bottomNav
         val navHostFragment = supportFragmentManager
             .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
         navHostFragment?.let {
             NavigationUI.setupWithNavController(
                 bottomNavigationView,
                 it.navController
             )
         }*/
    }

    private fun setFullScreen() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}
