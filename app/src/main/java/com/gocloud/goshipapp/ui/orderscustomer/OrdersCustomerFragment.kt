package com.gocloud.goshipapp.ui.orderscustomer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import androidx.lifecycle.Observer
import com.gocloud.goshipapp.databinding.FragmentOrdersCustomerBinding


class OrdersCustomerFragment : Fragment() {

    //companion object {
    //    fun newInstance() = OrdersCustomerFragment()
    //}

    private lateinit var ordersCustomerViewModel: OrdersCustomerViewModel
    private lateinit var binding: FragmentOrdersCustomerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ordersCustomerViewModel =
            ViewModelProvider(this).get(OrdersCustomerViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentOrdersCustomerBinding>(inflater,
            R.layout.fragment_orders_customer, container, false)


        ordersCustomerViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textCustomerorders.text = it
        })

        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         //ordersCustomerViewModel = ViewModelProvider(this).get(OrdersCustomerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
