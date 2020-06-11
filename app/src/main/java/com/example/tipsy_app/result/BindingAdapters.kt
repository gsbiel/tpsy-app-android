package com.example.tipsy_app.result

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.tipsy_app.tipsy.TipsyData

@BindingAdapter("tipResult")
fun TextView.setResult(data: TipsyData){
    data?.let{
        text = "%.2f".format(data.result)
    }
}

@BindingAdapter("tipComment")
fun TextView.setComment(data: TipsyData){
    data?.let{
        text = "Split between ${data.numberOfPersons} people, with ${data.tip} tip."
    }
}