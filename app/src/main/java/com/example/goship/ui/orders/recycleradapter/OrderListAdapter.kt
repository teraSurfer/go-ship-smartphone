package com.example.goship.ui.orders.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.goship.databinding.FragmentOrderItemListBinding
import com.example.goship.ui.orders.OrderFragmentDirections
import com.example.goship.ui.orders.OrderViewModel
import com.example.goship.ui.orders.Orders


//Adapter recycler as part of the Orders fragment
class OrderListAdapter(private val list: List<Orders>, private var orderViewModel: OrderViewModel)
    : RecyclerView.Adapter<OrderItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= FragmentOrderItemListBinding.inflate(inflater, parent, false)
        return OrderItemHolder(binding)
    }


    override fun onBindViewHolder(holderOrder: OrderItemHolder, position: Int) {
        val order: Orders = list[position]
        holderOrder.bind(order)

        holderOrder.itemView.setOnClickListener {
            val position = holderOrder.adapterPosition  //return to save position in OrderViewModel
            orderViewModel.getVMOrderAdapterPosition(position)
            val action  = OrderFragmentDirections.actionNavOrderToNavOrderDetails(orderPosition = position)
            it.findNavController().navigate(action)
            //Navigation.findNavController(view).navigate(R.id.action_nav_order_to_nav_orderDetails)
        }
    }


    override fun getItemCount(): Int = list.size

}