package com.gocloud.goshipapp.ui.orderdetails

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : Fragment() {

    //companion object {
    //    fun newInstance() = OrderDetailsFragment()
    //}

    private lateinit var orderDetailsViewModel: OrderDetailsViewModel
    private lateinit var binding: FragmentOrderDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orderDetailsViewModel =
            ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentOrderDetailsBinding>(inflater,
            R.layout.fragment_order_details, container, false )



        //return inflater.inflate(R.layout.fragment_order_details, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //orderDetailsViewModel = ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
