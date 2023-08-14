package com.example.compose.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.compose.models.Conversion

@Composable
fun TopScreen(listConverted: List<Conversion>) {
   val selectedConversion : MutableState<Conversion?> = remember {
      mutableStateOf(null)
   }
   val inputText : MutableState<String> = remember {
      mutableStateOf("")
   }
   ConversionMenu(conversionList = listConverted, modifier = Modifier){
       selectedConversion.value = it
   }

   selectedConversion.value?.let { 
      InputBlock(conversion = it, inputText = inputText){input->

      }
   }
}