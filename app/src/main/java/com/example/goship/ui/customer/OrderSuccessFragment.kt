package com.example.goship.ui.customer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.example.goship.R
import com.example.goship.databinding.FragmentOrderSuccessBinding
import com.example.goship.databinding.FragmentPlaceOrderBinding

class OrderSuccessFragment : Fragment() {

    companion object {
        fun newInstance() = OrderSuccessFragment()
    }

    private lateinit var viewModel: OrderSuccessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentOrderSuccessBinding>(inflater, R.layout.fragment_order_success,container,false)
        viewModel = ViewModelProviders.of(this).get(OrderSuccessViewModel::class.java)


        binding.textOrderId.text = "Order Id: "+OrderSuccessFragmentArgs.fromBundle(arguments!!).id.toString()
        binding.textVendorName.text = "Vendor Name: " + OrderSuccessFragmentArgs.fromBundle(arguments!!).vName
        binding.textVendorPhone.text = "Vendor Phone: " + OrderSuccessFragmentArgs.fromBundle(arguments!!).vMobile.toString()
        binding.textVendorEmail.text = "Vendor Email: " + OrderSuccessFragmentArgs.fromBundle(arguments!!).vEmail
        binding.textPrice.text = "Price: $"+ OrderSuccessFragmentArgs.fromBundle(arguments!!).price
        binding.textWeight.text = "Weight(KG): "+ OrderSuccessFragmentArgs.fromBundle(arguments!!).weight

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrderSuccessViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
