package com.example.vkcompose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcompose.R
import com.example.vkcompose.domain.FeedPost
import com.example.vkcompose.domain.StatisticItem
import com.example.vkcompose.domain.StatisticType
import java.lang.IllegalStateException


@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    fedPost: FeedPost,
    onLikeClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onViewClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
) {
    Card(
        modifier = modifier, border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            PostTitle(fedPost)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = fedPost.postText)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = fedPost.postImageResId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
//                    .weight(1f)
                    .fillMaxWidth()
            )
            PostStatistic(
                statisticItem = fedPost.statisticItems,
                onLikeClickListener = onLikeClickListener,
                onShareClickListener = onShareClickListener,
                onCommentClickListener = onCommentClickListener,
                onViewClickListener = onViewClickListener,
            )

        }
    }
}

@Composable
fun PostStatistic(
    statisticItem: List<StatisticItem>,
    onLikeClickListener: (StatisticItem) -> Unit,
    onShareClickListener: (StatisticItem) -> Unit,
    onViewClickListener: (StatisticItem) -> Unit,
    onCommentClickListener: (StatisticItem) -> Unit,
) {
    val viewsItem = statisticItem.getItemByType(StatisticType.VIEWS)
    val likesItem = statisticItem.getItemByType(StatisticType.LIKES)
    val sharedItem = statisticItem.getItemByType(StatisticType.SHARED)
    val commentsItem = statisticItem.getItemByType(StatisticType.COMMENT)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                iconRes = R.drawable.ic_baseline_remove_see,
                text = viewsItem.count.toString(),
                onClick = {
                    onViewClickListener(viewsItem)
                }
            )
        }
        Row(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            IconWithText(
                iconRes = R.drawable.ic_baseline_favorite_border_24,
                text = likesItem.count.toString(),
                onClick = {
                    onLikeClickListener(likesItem)
                }
            )
            IconWithText(
                iconRes = R.drawable.ic_baseline_message_24,
                text = commentsItem.count.toString(),
                onClick = {
                    onCommentClickListener(commentsItem)
                }
            )
            IconWithText(
                iconRes = R.drawable.ic_baseline_share_24,
                text = sharedItem.count.toString(),
                onClick = {
                    onShareClickListener(sharedItem)
                }
            )
        }
    }
}

private fun List<StatisticItem>.getItemByType(type: StatisticType): StatisticItem {
    return this.find { it.type == type } ?: throw IllegalStateException("Неверный тип")
}

@Composable
fun IconWithText(
    iconRes: Int,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            onClick()
        },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(painter = painterResource(id = iconRes), contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text)
    }
}

@Composable
fun PostTitle(fedPost: FeedPost) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = fedPost.communityImageResId),
            contentDescription = "Лого группы",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = fedPost.communityName, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = fedPost.postTime, fontSize = 8.sp, color = Color.Gray)

        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}