package com.example.vkcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.vkcompose.MainViewModel
import com.example.vkcompose.domain.FeedPost

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val scope = rememberCoroutineScope()
    val feedPostState = viewModel.feedPostState.observeAsState(FeedPost())

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

        ) {
        PostCard(
            modifier = Modifier.padding(8.dp),
            fedPost = feedPostState.value,
            onViewClickListener = viewModel::changePostState,
            onCommentClickListener = viewModel::changePostState,
            onLikeClickListener = viewModel::changePostState,
            onShareClickListener = viewModel::changePostState,
        )
    }
}