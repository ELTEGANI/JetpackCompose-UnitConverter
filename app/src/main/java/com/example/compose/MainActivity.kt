package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compose.data.ConvertedRepositoryIml
import com.example.compose.data.ConverterDatabase
import com.example.compose.compose.BaseScreen
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.viewModels.ConvertedViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dao = ConverterDatabase.getInstance(application).converterDAO
        val repository = ConvertedRepositoryIml(dao)
        val factory = ConvertedViewModelFactory(repository)
        setContent {
            ComposeTheme {
                BaseScreen(convertedViewModelFactory = factory)
            }
        }
    }
}


