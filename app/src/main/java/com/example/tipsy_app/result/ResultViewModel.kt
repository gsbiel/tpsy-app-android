package com.example.tipsy_app.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tipsy_app.tipsy.TipsyData

class ResultViewModel(data: TipsyData): ViewModel() {

    // ---------------------------------------------------------------------------------------------
    // TipsyData related properties
    private val _tipsyData = MutableLiveData<TipsyData>()
    val tipsyData: LiveData<TipsyData>
        get() = _tipsyData

    // ---------------------------------------------------------------------------------------------
    // Navigation related properties
    private val _navigateToCalculator = MutableLiveData<Boolean>()
    val navigateToCalculator: LiveData<Boolean>
        get() = _navigateToCalculator

    // ---------------------------------------------------------------------------------------------
    // Entry point
    init{
        _tipsyData.value = data
        _navigateToCalculator.value = false
    }

    fun recalculateBtnPressed(){
        _navigateToCalculator.value = true
    }

    fun navigateDone(){
        _navigateToCalculator.value = false
    }
}