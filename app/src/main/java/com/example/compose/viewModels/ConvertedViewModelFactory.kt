package com.example.compose.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.compose.data.ConvertorRepository
import javax.inject.Inject

class ConvertedViewModelFactory @Inject constructor(private val convertorRepository: ConvertorRepository):
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ConvertorViewModel(convertorRepository) as T
    }
}