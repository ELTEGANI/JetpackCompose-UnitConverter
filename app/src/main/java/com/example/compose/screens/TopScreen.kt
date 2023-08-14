package com.example.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.models.Conversion

@Composable
fun TopScreen(listConverted: List<Conversion>) {
   ConversionMenu(conversionList = listConverted, modifier = Modifier)
}