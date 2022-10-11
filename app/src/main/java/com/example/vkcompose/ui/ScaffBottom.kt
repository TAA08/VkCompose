package com.example.vkcompose.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ScafBot() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Это тулбар",
                        Modifier.fillMaxWidth()
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            val listOfText = listOf("Первый", "Второй", "Третий")
            BottomNavigation(backgroundColor = Color.Cyan) {
                listOfText.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Rounded.AccountBox,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = item) },
                        selected = true, onClick = { /*TODO*/ })
                }


            }
        },
        drawerContent = {
            Text(text = "Текст 1")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Текст 2")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Текст 3")
        }
    ) {

        Text(text = "Это текст экрана", modifier = Modifier.padding(it))


    }
}