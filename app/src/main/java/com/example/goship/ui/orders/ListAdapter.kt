package com.example.goship.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


//Adapter recycler as part of the fragment
class ListAdapter(private val list: List<Orders>)
    : RecyclerView.Adapter<OrderItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OrderItemHolder(inflater, parent)
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