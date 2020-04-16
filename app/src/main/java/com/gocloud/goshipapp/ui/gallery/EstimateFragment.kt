package com.gocloud.goshipapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentEstimateBinding

class EstimateFragment : Fragment() {

    private lateinit var estimateViewModel: EstimateViewModel
    private lateinit var binding: FragmentEstimateBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        estimateViewModel =
            ViewModelProvider(this).get(EstimateViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentEstimateBinding>(inflater,
            R.layout.fragment_estimate, container, false)

        estimateViewModel.text.observe(viewLifecycleOwner, Observer {
           binding.textEstimate.text = it
        })

        return binding.root
    }
}