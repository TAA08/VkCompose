package com.example.vkcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.PostScreen.route,
        builder = {
            composable(route = Screen.PostScreen.route, content = {
                homeScreenContent()
            })

            composable(route = Screen.FavouriteScreen.route, content = {
                favouriteScreenContent()
            })

            composable(route = Screen.ProfileScreen.route, content = {
                profileScreenContent()
            })
        }
    )
}