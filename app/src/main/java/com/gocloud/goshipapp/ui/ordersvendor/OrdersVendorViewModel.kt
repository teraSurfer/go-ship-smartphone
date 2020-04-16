package com.gocloud.goshipapp.ui.ordersvendor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrdersVendorViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _text = MutableLiveData<String>().apply {
        value = "This is send Customer Orders Fragment"
    }
    val text: LiveData<String> = _text

}
