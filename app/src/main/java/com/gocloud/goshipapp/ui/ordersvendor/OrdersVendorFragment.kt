package com.gocloud.goshipapp.ui.ordersvendor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentOrdersVendorBinding


class OrdersVendorFragment : Fragment() {

    //companion object {
    //    fun newInstance() = OrdersVendorFragment()
    //}

    private lateinit var ordersVendorViewModel: OrdersVendorViewModel
    private lateinit var binding: FragmentOrdersVendorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_orders_vendor, container, false)
        ordersVendorViewModel =
            ViewModelProvider(this).get(OrdersVendorViewModel::class.java)

        binding = DataBindingUtil.inflate<FragmentOrdersVendorBinding>(inflater,
            R.layout.fragment_orders_vendor, container, false)

        ordersVendorViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textVendorsorders.text = it
        })


        return  binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //ordersVendorViewModel = ViewModelProvider(this).get(OrdersVendorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
