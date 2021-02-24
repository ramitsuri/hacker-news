package com.ramitsuri.forumhub.android.logging

import android.util.Log
import timber.log.Timber

class ReleaseLogger : Timber.Tree() {
    override fun log(
        priority: Int, tag: String?, message: String,
        t: Throwable?
    ) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            // Log to Crash reporter
        }
    }
}