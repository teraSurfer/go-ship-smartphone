package com.gocloud.goshipapp.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShippingPricesViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Shipping Prices Fragment"
    }
    val text: LiveData<String> = _text
}