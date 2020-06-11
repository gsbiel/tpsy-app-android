package com.example.tipsy_app.tipsy

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
import com.example.tipsy_app.databinding.FragmentTipsyBinding

class TipsyFragment: Fragment(){

    private lateinit var binding: FragmentTipsyBinding
    private lateinit var viewModel: TipsyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tipsy, container, false)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this).get(TipsyViewModel::class.java)
        binding.viewModel = viewModel

        registerObservers()

        return binding.root
    }

    private fun registerObservers(){
        viewModel.navigateToResult.observe(viewLifecycleOwner, Observer {
            it?.let{
                val action = TipsyFragmentDirections.actionTipsyFragment2ToResultFragment()
                this.findNavController()?.navigate(action)
                viewModel.navigateDone()
            }
        })
    }
}