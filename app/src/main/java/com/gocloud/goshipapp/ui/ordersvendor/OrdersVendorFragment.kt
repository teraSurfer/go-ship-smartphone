package com.gocloud.goshipapp.ui.ordersvendor

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gocloud.goshipapp.R

class OrdersVendorFragment : Fragment() {

    companion object {
        fun newInstance() = OrdersVendorFragment()
    }

    private lateinit var viewModel: OrdersVendorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders_vendor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrdersVendorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
