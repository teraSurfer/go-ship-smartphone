package com.example.goship.ui.customer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class PlaceOrderViewModel : ViewModel() {
    var source: String =""
    var destination:String =""
    var weight: Int = 0

    var source_address: String = ""
    var destination_address: String = ""
    var source_mobile: String = ""
    var destination_mobile: String = ""
    var pickup_date: String = ""

    val price = MutableLiveData<String>()
}
