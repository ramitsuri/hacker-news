package com.ramitsuri.forumhub.android

import android.app.Application
import com.ramitsuri.forumhub.android.util.Logger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        initLogging()
    }

    private fun initLogging() {
        Logger.init(BuildConfig.DEBUG)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}