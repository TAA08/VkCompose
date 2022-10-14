package com.example.vkcompose.navigation

sealed class Screen(val route: String) {

    object PostScreen : Screen(ROUTE_POST_SCREEN)
    object FavouriteScreen : Screen(ROUTE_FAVOURITE_SCREEN)
    object ProfileScreen : Screen(ROUTE_PROFILE_SCREEN)

    companion object {
        private const val ROUTE_POST_SCREEN = "Post Screen"
        private const val ROUTE_FAVOURITE_SCREEN = "Favourite Screen"
        private const val ROUTE_PROFILE_SCREEN = "Profile Screen"
    }
}
