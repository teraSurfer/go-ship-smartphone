package com.example.goship.ui.vendor.price

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.goship.R

class UpdateLeastPriceFragment : Fragment() {

    companion object {
        fun newInstance() = UpdateLeastPriceFragment()
    }

    private lateinit var viewModel: UpdateLeastPriceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_update_least_price, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UpdateLeastPriceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
