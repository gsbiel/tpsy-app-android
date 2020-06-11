package com.example.tipsy_app.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.tipsy_app.R
import com.example.tipsy_app.databinding.FragmentResultBinding

class ResultFragment: Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: ResultViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(ResultViewModel::class.java)
        binding.viewModel = viewModel

        registerObservers()

        return binding.root
    }

    private fun registerObservers(){
        viewModel.navigateToCalculator.observe(viewLifecycleOwner, Observer {
            if(it){
                val action = ResultFragmentDirections.actionResultFragmentToTipsyFragment2()
                this.findNavController()?.navigate(action)
                viewModel.navigateDone()
            }
        })
    }
}