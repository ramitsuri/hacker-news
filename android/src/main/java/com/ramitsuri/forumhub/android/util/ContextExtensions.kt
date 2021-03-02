package com.ramitsuri.forumhub.android.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.InsetDrawable
import android.util.TypedValue
import android.view.MenuItem
import android.view.View
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu

@SuppressLint("RestrictedApi")
fun Context.showPopupMenu(v: View, @MenuRes menuRes: Int, itemClick: (MenuItem) -> Unit) {
    val popup = PopupMenu(this, v)
    popup.menuInflater.inflate(menuRes, popup.menu)
    popup.setOnMenuItemClickListener { menuItem: MenuItem ->
        itemClick(menuItem)
        true
    }
    val menuBuilder = popup.menu
    if (menuBuilder is MenuBuilder) {
        menuBuilder.setOptionalIconsVisible(true)
        for (item in menuBuilder.visibleItems) {
            val iconMarginPx =
                TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    16.toFloat(),
                    resources.displayMetrics
                ).toInt()
            if (item.icon != null) {
                item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0)
            }
        }
    }
    popup.show()
}