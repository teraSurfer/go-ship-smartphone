package com.example.goship.ui.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.goship.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goship.databinding.FragmentOrderBinding


class OrderFragment : Fragment() {
    //companion object {
    //    fun newInstance() = OrderFragment()
    //}

    private lateinit var orderViewModel: OrderViewModel
    private lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        orderViewModel =
            ViewModelProvider(this).get(OrderViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentOrderBinding>(inflater,
            R.layout.fragment_order, container, false)

//        ordersCustomerViewModel.text.observe(viewLifecycleOwner, Observer {
//            binding.textCustomerorders.text = it
//        })


        orderViewModel.vmListOrders.observe(viewLifecycleOwner, Observer {
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
        // TODO: Use the ViewModel
    }

}
