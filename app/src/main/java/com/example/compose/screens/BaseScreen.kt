package com.example.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.viewModels.ConvertorViewModel


@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    convertorViewModel: ConvertorViewModel = viewModel()
){
   val listConverted = convertorViewModel.getConversions()
   Column(modifier = modifier.padding(30.dp)) {
      TopScreen(listConverted)
      Spacer(modifier = modifier.height(20.dp))
      HistoryScreen()
   }
}