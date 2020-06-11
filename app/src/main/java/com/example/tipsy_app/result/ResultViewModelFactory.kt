package com.example.tipsy_app.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tipsy_app.tipsy.TipsyData
import java.lang.IllegalArgumentException

class ResultViewModelFactory(private val data: TipsyData): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ResultViewModel::class.java)){
            return ResultViewModel(data) as T
        }
        throw IllegalArgumentException("Unknown view model class")
    }
}