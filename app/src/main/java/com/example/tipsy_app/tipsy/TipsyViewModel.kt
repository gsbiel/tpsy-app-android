package com.example.tipsy_app.tipsy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TipsyViewModel: ViewModel(){

    // ---------------------------------------------------------------------------------------------
    // Navigation related properties
    private val _navigateToResult = MutableLiveData<Boolean>()
    val navigateToResult: LiveData<Boolean>
        get() = _navigateToResult

    // ---------------------------------------------------------------------------------------------
    // Class entry point
    init {
        _navigateToResult.value = false
    }

    fun calculateBtnPressed(){
        _navigateToResult.value = true
    }
    fun navigateDone(){
        _navigateToResult.value = false
    }
}