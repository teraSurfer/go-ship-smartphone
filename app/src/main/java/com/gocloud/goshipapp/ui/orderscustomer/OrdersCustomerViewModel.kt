package com.gocloud.goshipapp.ui.orderscustomer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class OrdersCustomerViewModel : ViewModel() {
    // TODO: Implement the ViewModel

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is send Customer Orders Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _listOrders = MutableLiveData<List<CustomerOrders>>().apply {
        value =  DataManager.customerOrders.values.toList()
    }
    val vmListOrders: LiveData<List<CustomerOrders>> = _listOrders


}