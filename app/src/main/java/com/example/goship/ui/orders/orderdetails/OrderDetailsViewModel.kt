package com.example.goship.ui.orders.orderdetails

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class OrderDetailsViewModel : ViewModel() {
    val vmTextOrderPosition = MutableLiveData<String>()


    fun getVMOrderPosition(  position: Int) {
        vmTextOrderPosition.value = "Card Position : ${position.toString()} "
//        vmTextCityName.value = "Weather of ${cities.values.toList().get(orderPosition).cityName} city "
//        vmWeatherCityName.value = cities.values.toList().get(orderPosition).cityName
//        vmWeatherCityId.value = cities.values.toList().get(orderPosition).cityId
        Log.i("OrderDetailsViewModel", position.toString())
//        getWeatherProperties()
    }


}
