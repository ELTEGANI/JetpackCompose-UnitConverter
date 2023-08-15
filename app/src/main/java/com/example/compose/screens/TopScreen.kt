package com.example.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.compose.models.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(listConverted: List<Conversion>) {
   val selectedConversion : MutableState<Conversion?> = remember {
      mutableStateOf(null)
   }
   val inputText : MutableState<String> = remember {
      mutableStateOf("")
   }
   val typedValue = remember {
      mutableStateOf("0.0")
   }

   ConversionMenu(conversionList = listConverted, modifier = Modifier){
       selectedConversion.value = it
   }

   selectedConversion.value?.let { 
      InputBlock(conversion = it, inputText = inputText){input->
          typedValue.value = input
      }
   }

   if(typedValue.value != "0.0"){
      val input = typedValue.value.toDouble()
      val multiply = selectedConversion.value!!.multiplyBy
      val result = input* multiply
      val df = DecimalFormat("#.####")
      df.roundingMode = RoundingMode.DOWN
      val roundedResult = df.format(result)
      val message1 = "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
      val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
      ResultBlock(message1 = message1, message2 = message2, modifier = Modifier)
   }
}