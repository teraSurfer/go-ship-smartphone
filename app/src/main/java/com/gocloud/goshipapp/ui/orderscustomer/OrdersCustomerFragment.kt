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
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gocloud.goshipapp.databinding.FragmentOrdersCustomerBinding
import com.sacefe.weatherapp.ui.weather.ListAdapter


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

//        ordersCustomerViewModel.text.observe(viewLifecycleOwner, Observer {
//            binding.textCustomerorders.text = it
//        })


        ordersCustomerViewModel.vmListOrders.observe(viewLifecycleOwner, Observer {
            binding.ordersCustomerList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = LinearLayoutManager(activity)
                // set the custom adapter to the RecyclerView
                adapter = ListAdapter(it)
            }
//            .getAdapterPositio // .listItemsRcy.adapter.  .setOnItemClickListener { parent, view:View, position, id ->
////                val action  =  OrdersCustomerFragmentDirections.actionNavOrderscustomerToNavOrderDetails
////                view.findNavController().navigate(action)
//                Navigation.findNavController(view).navigate(R.id.action_nav_orderscustomer_to_nav_orderDetails)
//            }

        })


        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         //ordersCustomerViewModel = ViewModelProvider(this).get(OrdersCustomerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
