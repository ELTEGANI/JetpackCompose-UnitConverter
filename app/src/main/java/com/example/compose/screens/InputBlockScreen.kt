package com.example.compose.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.data.Conversion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBlock(
    conversion: Conversion,
    inputText:MutableState<String>,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    calculate : (String)-> Unit
){
   Column(modifier = modifier.padding(0.dp,10.dp,0.dp,0.dp)) {
      Row(modifier = modifier.fillMaxWidth()){
          TextField(
              value = inputText.value,
              onValueChange = {
                  inputText.value = it
              },
              modifier = Modifier.fillMaxWidth(0.65F),
              keyboardOptions = KeyboardOptions(
                  capitalization = KeyboardCapitalization.None,
                  autoCorrect = true,
                  keyboardType = KeyboardType.Number
              ),
              colors = TextFieldDefaults.textFieldColors(
                  textColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.6F)
              ),
              textStyle = TextStyle(color = Color.DarkGray, fontSize = 30.sp)
          )
          Text(text = conversion.convertFrom,
              fontSize = 24.sp,
              modifier = modifier
                  .padding(10.dp, 30.dp, 0.dp, 0.dp)
                  .fillMaxWidth(
                      0.38F
                  ))
      }
       Spacer(modifier = modifier.height(20.dp))
       Column(
       ) {
           OutlinedButton(
               onClick = {
                   if (inputText.value != "") {
                       calculate(inputText.value)
                   } else {
                       Toast.makeText(context, "Please Enter Your Value", Toast.LENGTH_LONG)
                           .show()
                   }
               },
               modifier = modifier.fillMaxWidth(1F)
           ) {
               Text(
                   text = "Convert",
                   fontSize = 26.sp,
                   fontWeight = FontWeight.Bold,
                   color = Color.Blue
               )
           }
       }
   }
}