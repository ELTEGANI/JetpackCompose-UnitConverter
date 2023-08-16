package com.example.compose.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.compose.history.HistoryScreen
import com.example.compose.compose.convertor.TopScreen
import com.example.compose.viewModels.ConvertorViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    convertorViewModel: ConvertorViewModel = hiltViewModel()
){
   val listConverted = convertorViewModel.getConversions()
   val historyList = convertorViewModel.resultList.collectAsState(initial = emptyList())
   Column(modifier = modifier.padding(30.dp)) {
      TopScreen(listConverted){message1,message2->
          convertorViewModel.addResult(message1,message2)
      }
      Spacer(modifier = modifier.height(20.dp))
      HistoryScreen(historyList,{item->
          convertorViewModel.removeResult(item)
      },{
        convertorViewModel.clearAll()
      })
   }
}