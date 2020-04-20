package com.example.goship.ui.orders.orderdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.goship.R
import com.example.goship.databinding.FragmentOrderDetailsBinding


class OrderDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = OrderDetailsFragment()
    }

    private lateinit var orderDetailsViewModel: OrderDetailsViewModel
    private lateinit var binding: FragmentOrderDetailsBinding
    private var orderPosition: Int = 0

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orderDetailsViewModel =
            ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_order_details, container, false)

        orderDetailsViewModel.vmTextOrderPosition.observe(viewLifecycleOwner, Observer{
            binding.textOrderPosition.setText(it)
        })

        binding.textOrderPosition

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        orderDetailsViewModel = ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        // TODO: Use the ViewModel
        orderPosition = OrderDetailsFragmentArgs.fromBundle(arguments!!).orderPosition
        orderDetailsViewModel.getVMOrderPosition(orderPosition)

    }

}
