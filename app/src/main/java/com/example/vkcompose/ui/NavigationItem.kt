package com.example.vkcompose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkcompose.R

sealed class NavigationItem(
    val titleResId: Int,
    val icon: ImageVector
) {

    object Home : NavigationItem(
        titleResId = R.string.nav_item_home,
        icon = Icons.Rounded.Home
    )

    object Favourite : NavigationItem(
        titleResId = R.string.nav_item_favourite,
        icon = Icons.Rounded.Favorite
    )

    object Profile : NavigationItem(
        titleResId = R.string.nav_item_some,
        icon = Icons.Rounded.Person
    )
}