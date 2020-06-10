package com.example.tipsy_app.tipsy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tipsy_app.R
import com.example.tipsy_app.databinding.FragmentTipsyBinding

class TipsyFragment: Fragment(){

    private lateinit var binding: FragmentTipsyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tipsy, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}