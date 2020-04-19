package com.example.goship.ui.orders.recycleradapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.goship.databinding.FragmentOrderItemListBinding
import com.example.goship.ui.orders.Orders


//Adapter recycler as part of the Orders fragment
class OrderListAdapter(private val list: List<Orders>)
    : RecyclerView.Adapter<OrderItemHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= FragmentOrderItemListBinding.inflate(inflater, parent, false)
        return OrderItemHolder(binding)
    }


    override fun onBindViewHolder(holderOrder: OrderItemHolder, position: Int) {
        val city: Orders = list[position]
        holderOrder.bind(city)

        holderOrder.itemView.setOnClickListener {
            val position = holderOrder.adapterPosition
            //val action  = WeatherFragmentDirections.actionNavWeatherToNavCity(weatherPosition = position!!)
            //    it.findNavController().navigate(action)
        }

    }


    override fun getItemCount(): Int = list.size

}