package com.example.vkcompose.ui

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val snackBarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember {
        mutableStateOf(true)
    }

//    Log.d("MainScreen", "Recomposition2 ${fabIsVisible.value}")

    Scaffold(
        bottomBar = {
            BottomNavigation() {
                val selectedPosition = remember {
                    mutableStateOf(0)
                }
                val items =
                    listOf(
                        NavigationItem.Home,
                        NavigationItem.Profile,
                        NavigationItem.Favourite
                    )
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedPosition.value == index,
                        onClick = { selectedPosition.value = index },
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
        floatingActionButton = {
            Log.d("MainScreen", "Recomposition floatingActionButton")
            if (fabIsVisible.value) {
                FloatingActionButton(onClick = {
                    scope.launch {
                        val action = snackBarHostState.showSnackbar(
                            message = "Это текст snackBar",
                            actionLabel = "Скрыть кнопку",
                            duration = SnackbarDuration.Long
                        )
                        if (action == SnackbarResult.ActionPerformed) {
                            fabIsVisible.value = false
                        }
                    }

                }) {
                    Icon(imageVector = Icons.Rounded.Favorite, contentDescription = null)
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
            Log.d("MainScreen", "Recomposition snackbarHost")
        }
    ) {


    }
}