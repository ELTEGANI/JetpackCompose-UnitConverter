package com.example.compose.compose.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.compose.data.ConversionResult


@Composable
fun HistoryScreen(historyList: State<List<ConversionResult>>,
                  onCloseTask:(ConversionResult)->Unit,
                  onClearAllTask:()->Unit,
                  modifier: Modifier = Modifier) {
    Column {
        if(historyList.value.isNotEmpty()){
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "History", color = Color.Gray)
                OutlinedButton(onClick = {onClearAllTask()}) {
                    Text(text = "clear All", color = Color.Gray)
                }
            }
        }
    }
 HistroyList(list = historyList, onCloseTask = {item->
     onCloseTask(item)
 })
}