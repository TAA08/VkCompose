package com.example.vkcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vkcompose.domain.FeedPost
import com.example.vkcompose.domain.StatisticItem

class MainViewModel : ViewModel() {

    private val _feedPostState = MutableLiveData(FeedPost())
    val feedPostState: LiveData<FeedPost> get() = _feedPostState

    fun changePostState(item: StatisticItem) {
        val oldStatistic = feedPostState.value?.statisticItems ?: throw IllegalStateException()
        val newStatistic = oldStatistic.toMutableList().apply {
            replaceAll { oldItem ->
                if (oldItem.type == item.type) {
                    item.copy(count = oldItem.count + 1)
                } else {
                    oldItem
                }
            }
        }
        _feedPostState.value = feedPostState.value?.copy(statisticItems = newStatistic)
    }
}