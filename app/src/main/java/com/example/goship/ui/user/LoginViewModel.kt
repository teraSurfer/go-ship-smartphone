package com.example.goship.ui.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goship.dataproperty.DivisionProperty
import com.example.goship.network.AddCustomerAPI
import com.example.goship.network.DivisionAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    val email = MutableLiveData<String>()
    val isCustomer = MutableLiveData<Boolean>()

    init {
        email.value = ""
        isCustomer.value = true
    }
}
