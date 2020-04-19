package com.example.goship.ui.orders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {


    private val _listOrders = MutableLiveData<List<Orders>>().apply {
        value =  DataManager.customerOrders.values.toList()
    }
    val vmListOrders: LiveData<List<Orders>> = _listOrders


    fun getVMOrderAdapterPosition(  position: Int) {
      //save previous position Not used yet
      val  myOrderPosition = position
        Log.i("OrderListAdapter", position.toString())
    }



}
