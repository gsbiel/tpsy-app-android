package com.example.tipsy_app.tipsy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.selects.select

class TipsyViewModel: ViewModel(){

    val firstTip: Int = 0
    val secondTip: Int = 10
    val thirdTip: Int = 20

    // ---------------------------------------------------------------------------------------------
    // Stepper related properties
    private val _currentSteper = MutableLiveData<Int>()
    val stepperString = Transformations.map(_currentSteper){
        it.toString()
    }

    // ---------------------------------------------------------------------------------------------
    // Tip buttons related properties
    private val _firstTipState = MutableLiveData<Boolean>()
    val firstTipState: LiveData<Boolean>
        get() = _firstTipState

    private val _secondTipState = MutableLiveData<Boolean>()
    val secondTipState: LiveData<Boolean>
        get() = _secondTipState

    private val _thirdTipState = MutableLiveData<Boolean>()
    val thirdTipState: LiveData<Boolean>
        get() = _thirdTipState

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
        selectTip(firstTip)
    }

    fun tipBtnPressed(tip: Int){
        when(tip){
            firstTip -> selectTip(firstTip)
            secondTip -> selectTip(secondTip)
            thirdTip -> selectTip(thirdTip)
        }
    }

    fun selectTip(tip: Int){

        _firstTipState.value = false
        _secondTipState.value = false
        _thirdTipState.value = false

        return when(tip){
            firstTip -> _firstTipState.value = true
            secondTip -> _secondTipState.value = true
            thirdTip -> _thirdTipState.value = true
            else -> _firstTipState.value = true
        }
    }

    fun increaseStepper(){
        _currentSteper.value = _currentSteper.value!! + 1
    }

    fun decreaseStepper(){
        if(_currentSteper.value!! > 0){
            _currentSteper.value = _currentSteper.value!! - 1
        }
    }

    fun calculateBtnPressed(){
        _navigateToResult.value = true
    }

    fun navigateDone(){
        _navigateToResult.value = false
    }
}