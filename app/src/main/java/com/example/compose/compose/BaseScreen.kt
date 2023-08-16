package com.example.compose.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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
   val configuration = LocalConfiguration.current
   var isLandScape by remember {
       mutableStateOf(false)
   }
   when(configuration.orientation){
       Configuration.ORIENTATION_LANDSCAPE->{
           isLandScape = true
         Row(modifier = modifier
             .padding(30.dp)
             .fillMaxSize(),
             horizontalArrangement = Arrangement.SpaceAround) {
               TopScreen(listConverted,
                   convertorViewModel.selectedConversion,
                   convertorViewModel.inputText,
                   convertorViewModel.typedValue,
                   isLandScape){message1,message2->
                   convertorViewModel.addResult(message1,message2)
               }
               Spacer(modifier = modifier.width(10.dp))
               HistoryScreen(historyList,{item->
                   convertorViewModel.removeResult(item)
               },{
                   convertorViewModel.clearAll()
               })
           }
       }else->{
         isLandScape = false
         Column(modifier = modifier.padding(30.dp)) {
           TopScreen(listConverted,
               convertorViewModel.selectedConversion,
               convertorViewModel.inputText,
               convertorViewModel.typedValue,
               isLandScape){message1,message2->
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
   }
}