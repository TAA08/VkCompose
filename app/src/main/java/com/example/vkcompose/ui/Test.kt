package com.example.vkcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@Preview
@Composable
fun Test() {
    Column {
//        TestText(count = 5, text = "Test")
        AlertTest()
    }

}

@Composable
fun ColumnScope.TestText(
    count: Int,
    text: String
) {
    repeat(count) {
        Text(text = text, modifier = Modifier.weight(1f))
    }

}

@Composable
fun AlertTest() {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text(text = "Отмена действия") },
        text = { Text(text = "Вы действительно хотите отменить это действие?") },
        buttons = { Button(onClick = { /*TODO*/ }) {
            Text(text = "Да")

        }}
    )
}