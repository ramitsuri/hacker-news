package com.ramitsuri.forumhub.android

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.ramitsuri.forumhub.android.databinding.ActivityMainBinding
import timber.log.Timber


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpNavigation()
        setFullScreen()
        // Set dark nav and status bar if light theme
        if (resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_NO
        ) {
            Timber.i("Light theme, setting status and nav bar light flag")
            WindowInsetsControllerCompat(window, window.decorView)
                .isAppearanceLightStatusBars = true

        }
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
