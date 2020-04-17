package com.gocloud.goshipapp.ui.ordersvendor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentOrdersVendorBinding
import com.sacefe.weatherapp.ui.weather.ListAdapter


class OrdersVendorFragment : Fragment() {

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


        ordersVendorViewModel.vmListOrders.observe(viewLifecycleOwner, Observer {
            binding.ordersCustomerList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView
                adapter = ListAdapter(it)
            }
        })

        return  binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //ordersVendorViewModel = ViewModelProvider(this).get(OrdersVendorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
