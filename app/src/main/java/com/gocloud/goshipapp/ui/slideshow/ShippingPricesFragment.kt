package com.gocloud.goshipapp.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentShippingpricesBinding

class ShippingPricesFragment : Fragment() {

    private lateinit var shippingPricesViewModel: ShippingPricesViewModel
    private lateinit var binding: FragmentShippingpricesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shippingPricesViewModel =
            ViewModelProvider(this).get(ShippingPricesViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentShippingpricesBinding>(inflater,
            R.layout.fragment_shippingprices, container, false)


        shippingPricesViewModel.text.observe(viewLifecycleOwner, Observer {
           binding.textShippingprices.text = it
        })
        return binding.root
    }
}

