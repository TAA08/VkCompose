package com.example.vkcompose.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vkcompose.MainViewModel
import com.example.vkcompose.navigation.AppNavGraph


@Composable
fun MainScreen(viewModel: MainViewModel) {

    val scope = rememberCoroutineScope()
//    Log.d("MainScreen", "Recomposition2 ${fabIsVisible.value}")
//    val selectedNavItem by viewModel.selectedNavItem.observeAsState(NavigationItem.Home)
    val navHostController = rememberNavController()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            BottomNavigation() {

                val items =
                    listOf(
                        NavigationItem.Home,
                        NavigationItem.Profile,
                        NavigationItem.Favourite
                    )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.screen.route,
                        onClick = { navHostController.navigate(item.screen.route) },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        },
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navHostController,
            homeScreenContent = {
                HomeScreen(
                    viewModel = viewModel,
                    paddingValues = paddingValues
                )
            },
            favouriteScreenContent = { Text(text = "Favourite", color = Color.Black) },
            profileScreenContent = { Text(text = "ProfileGI", color = Color.Black) })
    }
}