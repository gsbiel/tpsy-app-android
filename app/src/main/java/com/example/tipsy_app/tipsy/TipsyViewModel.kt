package com.example.tipsy_app.tipsy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class TipsyViewModel: ViewModel(){


    private val _currentSteper = MutableLiveData<Int>()
    val stepperString = Transformations.map(_currentSteper){
        it.toString()
    }


    // ---------------------------------------------------------------------------------------------
    // Navigation related properties
    private val _navigateToResult = MutableLiveData<Boolean>()
    val navigateToResult: LiveData<Boolean>
        get() = _navigateToResult

    // ---------------------------------------------------------------------------------------------
    // Class entry point
    init {
        _navigateToResult.value = false
        _currentSteper.value = 0
    }

    fun calculateBtnPressed(){
        _navigateToResult.value = true
    }
    fun navigateDone(){
        _navigateToResult.value = false
    }
    fun increaseStepper(){
        _currentSteper.value = _currentSteper.value!! + 1
    }
    fun decreaseStepper(){
        if(_currentSteper.value!! > 0){
            _currentSteper.value = _currentSteper.value!! - 1
        }
    }
}