package com.example.goship.ui.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.goship.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goship.databinding.FragmentOrderBinding
import com.example.goship.ui.orders.recycleradapter.OrderListAdapter


class OrderFragment : Fragment() {

    companion object {
        fun newInstance() = OrderFragment()
    }

    private lateinit var orderViewModel: OrderViewModel
    private lateinit var binding: FragmentOrderBinding
    private lateinit var ordersId: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        orderViewModel =
            ViewModelProvider(this).get(OrderViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentOrderBinding>(inflater,
            R.layout.fragment_order, container, false)


        orderViewModel.vmArraytId.observe(viewLifecycleOwner, Observer {
            ordersId = it.copyOf()
        })

        orderViewModel.vmListOrders.observe(viewLifecycleOwner, Observer {
            binding.ordersCustomerList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = activity?.let { it1 -> LinearLayoutManager(it1) }
                // set the custom adapter to the RecyclerView
                adapter = OrderListAdapter(it, orderViewModel, ordersId)
            }
        })

        orderViewModel.failureResponse.observe(viewLifecycleOwner, Observer {
            Toast.makeText(getContext(),
                "Network Error: ${it}", Toast.LENGTH_LONG).show()
        })


        return  binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        orderViewModel = ViewModelProvider(this).get(orderViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
