package com.ramitsuri.forumhub.android.util

import android.widget.TextView
import androidx.annotation.DrawableRes

fun TextView.setIconStart(@DrawableRes resId: Int) {
    this.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0)
}