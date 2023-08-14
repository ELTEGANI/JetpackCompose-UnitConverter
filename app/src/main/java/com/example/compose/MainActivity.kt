package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MyViewModel>()
            ComposeTheme {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    val count = viewModel.count
                    MyButton(currentCount = count) {
                        viewModel.increaseCount()
                    }
                }
            }
        }
    }
}

@Composable
fun MyButton(currentCount: Int,updateCount:(Int)->Unit) {
    Button(onClick = {
        updateCount(currentCount)
    },
        contentPadding = PaddingValues(20.dp),
        border = BorderStroke(4.dp, Color.Black),
        colors = ButtonDefaults.textButtonColors(
            contentColor = Color.White)
    ) {
       Text(text = "Count is : $currentCount",
           style = MaterialTheme.typography.bodyMedium,
           color = Color.Black
       )
    }
}

