package com.example.vkcompose.domain

data class StatisticItem(
    val count: Int,
    val type: StatisticType,
    )

enum class StatisticType {
    VIEWS, LIKES, COMMENT, SHARED
}