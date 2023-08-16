package com.example.compose.compose.history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import com.example.compose.data.ConversionResult


@Composable
fun HistroyList(
    list: State<List<ConversionResult>>,
    onCloseTask: (ConversionResult) -> Unit,
    modifier: Modifier = Modifier
){
   LazyColumn{
       items(items = list.value, key = {item->item.id}){item->
           HistoryItem(
               messagePart1 = item.messagePart1,
               messagePart2 = item.messagePart2,
               onClose = { onCloseTask(item)},
               modifier = modifier
           )
       }
   }
}