package com.ramitsuri.forumhub.android.util

import com.ramitsuri.forumhub.android.logging.ReleaseLogger
import timber.log.Timber

object Logger {

    fun init(debug: Boolean) {
        if (debug) {
            Timber.plant(Timber.DebugTree());
        } else {
            Timber.plant(ReleaseLogger());
        }
    }

    fun i(tag: String, message: String) {
        Timber.tag(tag).i(message)
    }

    fun d(tag: String, message: String) {
        Timber.tag(tag).d(message)
    }

    fun w(tag: String, message: String) {
        Timber.tag(tag).w(message)
    }

    fun e(tag: String, message: String) {
        Timber.tag(tag).e(message)
    }
}
