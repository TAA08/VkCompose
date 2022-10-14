package com.example.vkcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vkcompose.domain.FeedPost
import com.example.vkcompose.domain.StatisticItem
import com.example.vkcompose.ui.NavigationItem

class MainViewModel : ViewModel() {

    private val sourcePost = mutableListOf<FeedPost>().apply {
        repeat(20) {
            add(FeedPost(id = it))
        }
    }

    private val _listVkPost = MutableLiveData<List<FeedPost>>(sourcePost)
    val listVkPost: LiveData<List<FeedPost>> get() = _listVkPost

    private val _selectedNavItem = MutableLiveData<NavigationItem>(NavigationItem.Home)
    val selectedNavItem: LiveData<NavigationItem> get() = _selectedNavItem

    fun navigate(item: NavigationItem){
        _selectedNavItem.value = item
    }

    fun changePostState(post: FeedPost, item: StatisticItem) {
//        получаем список постов
        val oldPost = listVkPost.value?.toMutableList() ?: mutableListOf()
//        получпем список элементов статистики
        val oldStatistic = post.statisticItems
        val newStatistic = oldStatistic.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    item.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
//        получаем пост с измененной статистикой
        val newFeedPost = post.copy(statisticItems = newStatistic)
//        заменяем список постов на список с измененным постом
        _listVkPost.value = oldPost.apply {
            replaceAll { oldPost ->
                if (oldPost.id == newFeedPost.id) {
                    newFeedPost
                } else {
                    oldPost
                }
            }
        }
    }

    fun deletePost(post: FeedPost) {
        val oldPost = listVkPost.value?.toMutableList() ?: mutableListOf()
        oldPost.remove(post)
        _listVkPost.value = oldPost
    }
}