package com.example.compose.compose.convertor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.compose.data.Conversion
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TopScreen(listConverted: List<Conversion>,
              selectedConversion:MutableState<Conversion?>,
              inputText:MutableState<String>,
              typedValue:MutableState<String>,
              isLandScape:Boolean,
               save:(String,String)->Unit) {


    var toSave by remember {
        mutableStateOf(false)
    }

    Column(modifier =
    Modifier.verticalScroll(rememberScrollState())) {
        ConversionMenu(
            conversionList = listConverted,
            isLandScape, modifier = Modifier
        ) {
            selectedConversion.value = it
            typedValue.value = "0.0"
        }

        selectedConversion.value?.let {
            InputBlock(conversion = it, inputText = inputText, isLandScape) { input ->
                typedValue.value = input
                toSave = true
            }
        }

        if (typedValue.value != "0.0") {
            val input = typedValue.value.toDouble()
            val multiply = selectedConversion.value!!.multiplyBy
            val result = input * multiply
            val df = DecimalFormat("#.####")
            df.roundingMode = RoundingMode.DOWN
            val roundedResult = df.format(result)
            val message1 =
                "${typedValue.value} ${selectedConversion.value!!.convertFrom} is equal to"
            val message2 = "$roundedResult ${selectedConversion.value!!.convertTo}"
            if (toSave) {
                save(message1, message2)
                toSave = false
            }
            ResultBlock(message1 = message1, message2 = message2, modifier = Modifier)
        }
    }
}