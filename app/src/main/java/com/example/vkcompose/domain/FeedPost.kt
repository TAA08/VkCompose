package com.example.vkcompose.domain

import com.example.vkcompose.R

data class FeedPost(
    val id: Int = 1,
    val communityName: String = "уволено",
    val communityImageResId: Int = R.drawable.ic_pumpkin,
    val postText: String = "Тут будет текст поста, а сейчас тут просто текст для вида!",
    val postImageResId: Int = R.drawable.images,
    val postTime: String = "14:00",
    val statisticItems: List<StatisticItem> = listOf(
        StatisticItem(count = 966, type = StatisticType.COMMENT),
        StatisticItem(count = 8765, type = StatisticType.LIKES),
        StatisticItem(count = 200, type = StatisticType.SHARED),
        StatisticItem(count = 20000, type = StatisticType.VIEWS)
    ),
)
