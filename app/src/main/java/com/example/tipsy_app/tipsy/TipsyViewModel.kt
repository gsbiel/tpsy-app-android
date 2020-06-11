package com.example.tipsy_app.tipsy

import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TipsyData(val result: Double, val numberOfPersons: Int, val tip: String): Parcelable

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

    // EditText related properties
    // This mutable property is exposed because i am using two way databinding with
    // fragment_tipsy layout file
    val totalValue = MutableLiveData<String>()

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
    private val _navigateToResult = MutableLiveData<TipsyData>()
    val navigateToResult: LiveData<TipsyData>
        get() = _navigateToResult

    // ---------------------------------------------------------------------------------------------
    // Class entry point
    init {
        _navigateToResult.value = null
        _currentSteper.value = 0
        totalValue.value = ""
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
        val amount = totalValue.value?.toDoubleOrNull()
        val currentTip = getActiveTip()
        amount?.let{
            val result = calculateTipFor(it,_currentSteper.value!!,currentTip)
            val data = TipsyData(result,_currentSteper.value!!, "${currentTip}%")
            _navigateToResult.value = data
        }
    }

    fun navigateDone(){
        _navigateToResult.value = null
    }

    private fun calculateTipFor(totalAmount: Double, numberOfPersons: Int, tip: Int): Double{
        val result: Double = ((1 + tip/100.0)*totalAmount)/numberOfPersons.toDouble()
        return result
    }

    private fun getActiveTip(): Int{
        if(firstTipState.value!!){
            return firstTip
        }else if(secondTipState.value!!){
            return secondTip
        }else{
            return thirdTip
        }
    }
}