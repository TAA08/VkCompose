package com.example.vkcompose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcompose.R

@Preview
@Composable
fun PostCard() {
    Card(
        modifier = Modifier
            .fillMaxSize(), border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            PostTitle()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Тут будет текст поста, а сейчас тут просто текст для вида!")
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.images),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            PostStatistic()

        }
    }
}

@Composable
fun PostStatistic() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(iconRes = R.drawable.ic_baseline_remove_see, text = "848")

        }
        Row(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            IconWithText(iconRes = R.drawable.ic_baseline_favorite_border_24, text = "3434")
            IconWithText(iconRes = R.drawable.ic_baseline_message_24, text = "1234")
            IconWithText(iconRes = R.drawable.ic_baseline_share_24, text = "21343")
        }
    }
}

@Composable
fun IconWithText(
    iconRes: Int,
    text: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(id = iconRes), contentDescription = null, tint = Color.Gray)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text)
    }
}

@Composable
fun PostTitle() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pumpkin),
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
            Text(text = "уволено", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "14:00", fontSize = 8.sp, color = Color.Gray)

        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = Color.Gray
        )
    }
}