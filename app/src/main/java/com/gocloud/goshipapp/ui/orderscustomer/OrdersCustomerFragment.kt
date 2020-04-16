package com.gocloud.goshipapp.ui.orderscustomer

import android.os.Binder
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
//import com.gocloud.goshipapp.databinding.FragmentOrdersCustomerBinding

class OrdersCustomerFragment : Fragment() {

//    private lateinit var ordersCustomerViewModel: OrdersCustomerViewModel
//    private lateinit var binding: FragmentOrdersCustomerBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        ordersCustomerViewModel =
//            ViewModelProvider(this).get(OrdersCustomerViewModel::class.java)
//        binding = DataBindingUtil.inflate<FragmentOrdersCustomerBinding>(inflater,
//            R.layout.fragment_orders_customer, container, false)
//
//
//        ordersCustomerViewModel.text.observe(viewLifecycleOwner, Observer {
//            binding.textShippingprices.text = it
//        })
//        return binding.root
//    }

    companion object {
        fun newInstance() = OrdersCustomerFragment()
    }

    private lateinit var viewModel: OrdersCustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_orders_customer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrdersCustomerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
