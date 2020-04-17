package com.sacefe.weatherapp.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.ui.orderscustomer.CustomerOrders


//Equivalent to ModelView
class orderItemHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_order_item_list, parent, false)) {

//    private lateinit var binding: orderItemHolder

    private var mCityId: TextView? = null
    private var mCityName: TextView? = null


    init {
        mCityId =   itemView.findViewById(R.id.textOrderId)
        mCityName = itemView.findViewById(R.id.textOrderStatus)

            itemView?.setOnClickListener {
               //val itsCityIdTextView? =   itemView.findViewById(R.id.textCity).
               //val itsCityName: TextView? = itemView.findViewById(R.id.textCityName)
                val miii = 10
//                val action  = WeatherFragmentDirections.actionNavWeatherToNavCity(weatherPosition = position!!)
//                view.findNavController().navigate(action)
            }
    }

    fun bind(order: CustomerOrders) {
        mCityId?.text = "Order Id:  ${order.orderId.toString()}"
        mCityName?.text ="Order Status:  ${order.status}"
    }

}

//CODE OK
//class orderItemHolder(inflater: LayoutInflater, parent: ViewGroup) :
//    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_weather_list_fragment, parent, false)) {
//    private var mCityId: TextView? = null
//    private var mCityName: TextView? = null
//
//
//    init {
//        mCityId = itemView.findViewById(R.id.textCity)
//        mCityName = itemView.findViewById(R.id.textCityName)
//    }
//
//    fun bind(city: CityInfo) {
//        mCityId?.text = city.cityId.toString()
//        mCityName?.text = city.cityName
//    }
//
//}