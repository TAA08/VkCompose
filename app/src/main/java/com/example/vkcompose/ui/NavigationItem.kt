package com.example.vkcompose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vkcompose.R
import com.example.vkcompose.navigation.Screen

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector,
) {

    object Home : NavigationItem(
        titleResId = R.string.nav_item_home,
        icon = Icons.Rounded.Home,
        screen = Screen.PostScreen,
    )

    object Favourite : NavigationItem(
        titleResId = R.string.nav_item_favourite,
        icon = Icons.Rounded.Favorite,
        screen = Screen.FavouriteScreen,
    )

    object Profile : NavigationItem(
        titleResId = R.string.nav_item_some,
        icon = Icons.Rounded.Person,
        screen = Screen.ProfileScreen,
    )
}