package com.example.vkcompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vkcompose.MainViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues,
){
    val posts = viewModel.listVkPost.observeAsState(listOf())
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(top = 8.dp, bottom = 72.dp, start = 4.dp, end = 4.dp),
//            отступы между элементами
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(
                items = posts.value,
                key = { post -> post.id },
            ) { post ->
                val swipeState = rememberDismissState()
                if (swipeState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.deletePost(post)
                }
                SwipeToDismiss(
                    state = swipeState,
                    background = {},
                    directions = setOf(DismissDirection.EndToStart),
                    modifier = Modifier.animateItemPlacement()
                ) {
                    PostCard(
                        modifier = Modifier,
                        fedPost = post,
                        onViewClickListener = { statisticItem ->
                            viewModel.changePostState(post = post, item = statisticItem)
                        },
                        onLikeClickListener = { statisticItem ->
                            viewModel.changePostState(post = post, item = statisticItem)
                        },
                        onShareClickListener = { statisticItem ->
                            viewModel.changePostState(post = post, item = statisticItem)
                        },
                        onCommentClickListener = { statisticItem ->
                            viewModel.changePostState(post = post, item = statisticItem)
                        },
                    )
                }
            }
        },
    )
}