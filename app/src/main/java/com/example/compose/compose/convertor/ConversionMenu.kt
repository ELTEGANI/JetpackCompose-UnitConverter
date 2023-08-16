package com.example.compose.compose.convertor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.compose.data.Conversion


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversionMenu(conversionList:List<Conversion>,
                   isLandScape:Boolean,
                   modifier: Modifier,convert:(Conversion)->Unit){
    var displayText by rememberSaveable { mutableStateOf("Select the Conversion type") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }

    val icon = if(expanded)
        Icons.Filled.KeyboardArrowUp
        else
        Icons.Filled.KeyboardArrowDown

    Column {
        if (isLandScape){
            OutlinedTextField(
                value = displayText,
                onValueChange = { displayText = it },
                textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                modifier = modifier
                    .onGloballyPositioned { cordinates ->
                        textFieldSize = cordinates.size.toSize()
                    },
                label = { Text(text = "Conversion Type") },
                trailingIcon = {
                    Icon(icon, contentDescription = "icon",
                        modifier.clickable { expanded = !expanded })
                },
                readOnly = true
            )
        }else{
            OutlinedTextField(
                value = displayText,
                onValueChange = { displayText = it },
                textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                modifier = modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { cordinates ->
                        textFieldSize = cordinates.size.toSize()
                    },
                label = { Text(text = "Conversion Type") },
                trailingIcon = {
                    Icon(icon, contentDescription = "icon",
                        modifier.clickable { expanded = !expanded })
                },
                readOnly = true
            )
        }

    }
    DropdownMenu(expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier =  modifier.width(with(LocalDensity.current){
            textFieldSize.width.toDp()
        })) {
        conversionList.forEach{conversion ->
            DropdownMenuItem(text = { Text(text = conversion.description
            , fontSize = 18.sp
            , fontWeight = FontWeight.Normal)}, onClick = {
                displayText = conversion.description
                expanded =false
                convert(conversion)
            })
        }
    }
}