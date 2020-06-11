package com.example.tipsy_app.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel: ViewModel() {

    // ---------------------------------------------------------------------------------------------
    // Navigation related properties
    private val _navigateToCalculator = MutableLiveData<Boolean>()
    val navigateToCalculator: LiveData<Boolean>
        get() = _navigateToCalculator

    // ---------------------------------------------------------------------------------------------
    // Entry point
    init{
        _navigateToCalculator.value = false
    }

    fun recalculateBtnPressed(){
        _navigateToCalculator.value = true
    }

    fun navigateDone(){
        _navigateToCalculator.value = false
    }
}