package com.sacefe.weatherapp.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gocloud.goshipapp.ui.orderscustomer.CustomerOrders


//Require Fragment conversion
class ListAdapter(private val list: List<CustomerOrders>)
    : RecyclerView.Adapter<orderItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): orderItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        return orderItemHolder(inflater, parent)
    }

    override fun onBindViewHolder(holderOrder: orderItemHolder, position: Int) {
        val city: CustomerOrders = list[position]
        holderOrder.bind(city)

        holderOrder.itemView.setOnClickListener{
            val position = holderOrder.adapterPosition
            //val action  = WeatherFragmentDirections.actionNavWeatherToNavCity(weatherPosition = position!!)
            //    it.findNavController().navigate(action)
        }

    }


    override fun getItemCount(): Int = list.size

}

//CODE OK
//class ListAdapter(private val list: List<CityInfo>)
//    : RecyclerView.Adapter<orderItemHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): orderItemHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        return orderItemHolder(inflater, parent)
//    }
//
//    override fun onBindViewHolder(holder: orderItemHolder, position: Int) {
//        val city: CityInfo = list[position]
//        holder.bind(city)
//    }
//
//    override fun getItemCount(): Int = list.size
//
//}