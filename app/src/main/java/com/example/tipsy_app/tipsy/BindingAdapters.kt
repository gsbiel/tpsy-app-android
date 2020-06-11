package com.example.tipsy_app.tipsy

import android.widget.Button
import androidx.databinding.BindingAdapter
import com.example.tipsy_app.R

@BindingAdapter("firstTip")
fun Button.setFirstTipBackground(isActive: Boolean) {
    if(isActive){
        setTextColor(resources.getColor(R.color.tipDefaultColor))
        setBackgroundColor(resources.getColor(R.color.tipSelectedColor))
    }else{
        setTextColor(resources.getColor(R.color.tipSelectedColor))
        setBackgroundColor(resources.getColor(R.color.tipDefaultColor))
    }
}

@BindingAdapter("secondTip")
fun Button.setSecondTipBackground(isActive: Boolean) {
    if(isActive){
        setTextColor(resources.getColor(R.color.tipDefaultColor))
        setBackgroundColor(resources.getColor(R.color.tipSelectedColor))
    }else{
        setTextColor(resources.getColor(R.color.tipSelectedColor))
        setBackgroundColor(resources.getColor(R.color.tipDefaultColor))
    }
}

@BindingAdapter("thirdTip")
fun Button.setThirdTipBackground(isActive: Boolean) {
    if(isActive){
        setTextColor(resources.getColor(R.color.tipDefaultColor))
        setBackgroundColor(resources.getColor(R.color.tipSelectedColor))
    }else{
        setTextColor(resources.getColor(R.color.tipSelectedColor))
        setBackgroundColor(resources.getColor(R.color.tipDefaultColor))
    }
}