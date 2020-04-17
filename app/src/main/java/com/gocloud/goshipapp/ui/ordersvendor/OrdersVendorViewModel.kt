package com.gocloud.goshipapp.ui.ordersvendor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gocloud.goshipapp.ui.orderscustomer.CustomerOrders
import com.gocloud.goshipapp.ui.orderscustomer.DataManager

class OrdersVendorViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    private val _listOrders = MutableLiveData<List<CustomerOrders>>().apply {
        value =  DataManager.customerOrders.values.toList()
    }
    val vmListOrders: LiveData<List<CustomerOrders>> = _listOrders

}
