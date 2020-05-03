package com.example.goship.ui.orders.orderdetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goship.dataproperty.OrderSingle
import com.example.goship.network.OrderAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OrderDetailsViewModel : ViewModel() {
    val vmSpCities = MutableLiveData<Array<String>>()
    val vmTextOrderId = MutableLiveData<String>()
    val vmTextOrderPosition = MutableLiveData<String>()
    val vmTextClientEmail = MutableLiveData<String>()
    val vmTextVendorName = MutableLiveData<String>()
    val vmTextVendorPhone = MutableLiveData<String>()
    val vmTextVendorEmail = MutableLiveData<String>()
    val vmTextPrice = MutableLiveData<String>()
    val vmTextWeight = MutableLiveData<String>()
    val textOrigenDate = MutableLiveData<String>()
    val textOrigenMobile = MutableLiveData<String>()
    val textOrigenAddress = MutableLiveData<String>()
    val textPickDate = MutableLiveData<String>()
    val textDestinationMobile = MutableLiveData<String>()
    val textDestinationAddress = MutableLiveData<String>()
    var orderSelected = String()
    val failureResponse = MutableLiveData<String>()



    private val _textSelectIdLabel = MutableLiveData<String>().apply {
        value = "<b>Select ID: </b>"
    }
    val vmTtextSelectIdLabel: MutableLiveData<String> = _textSelectIdLabel


    private val _textVendorLabel = MutableLiveData<String>().apply {
        value = "<b>Vendor Information</b>"
    }
    val vmTextVendorLabel: LiveData<String> = _textVendorLabel


    private val _textShipLabel = MutableLiveData<String>().apply {
        value = "<b>Shipment Details</b>"
    }
    val vmTextShipLabel: LiveData<String> = _textShipLabel


    private val _textOriginLabel = MutableLiveData<String>().apply {
        value = "<b>Origen</b>"
    }
    val vmTextOriginLabel: LiveData<String> = _textOriginLabel

    private val _textDestinationLabel = MutableLiveData<String>().apply {
        value = "<b>Destination</b>"
    }
    val vmTextDestinationLabel: LiveData<String> = _textDestinationLabel



    fun getVMOrderPosition(  position: Int) {
        vmTextOrderPosition.value = position.toString()
        Log.i("OrderDetailsViewModel", position.toString())

    }

    fun getVMOrderSelected(  orderId: Any) {
        orderSelected = orderId.toString()
        vmTextOrderId.value = "<b>Order Id: </b><u> ${orderId.toString()}</u>"
        getOrderProperties()
        Log.i("OrderDetailsViewModel", orderId.toString())
    }

    fun getVMOrderIDs(  orderIDs: Array<String>) {
        vmSpCities.value = orderIDs.copyOf()
        Log.i("OrderDetailsViewModel", "Array of UDs")
    }

    private fun getOrderProperties() {
        OrderAPI.retrofitService.getProperties( orderSelected).enqueue(
            object: Callback<OrderSingle> {
                override fun onFailure(call: Call<OrderSingle>, t: Throwable ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    failureResponse.value = "Failure: " + t.message
                }
                override fun onResponse(call: Call<OrderSingle>, response: Response<OrderSingle>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    vmTextClientEmail.value =  "<b>Client email: </b><u>  ${response.body()?.u_email}</u>"
                    vmTextVendorName.value = "<b>Vendor Name: </b><u>  ${response.body()?.v_name}</u>"
                    vmTextVendorPhone.value ="<b>Phone: </b><u>  ${response.body()?.v_mobile}</u>"
                    vmTextVendorEmail.value = "<b>email: </b><u>  ${response.body()?.v_email}</u>"
                    vmTextPrice.value = "<b>Price: </b><u>  $${response.body()?.price}</u>"
                    vmTextWeight.value = "<b>Weight: </b><u>  ${response.body()?.weight}</u>"
                    textOrigenDate.value = "<b>Shipped date: </b><u>  ${response.body()?.o_date}</u>"
                    textOrigenMobile.value = "<b>Mobile: </b><u>  ${response.body()?.o_mobile}</u>"
                    textOrigenAddress.value = "<b>Address: </b><u>  ${response.body()?.o_address}</u>"
                    textPickDate.value = "<b>Pick up date: </b><u>  ${response.body()?.p_date}</u>"
                    textDestinationMobile.value = "<b>Mobile: </b><u>  ${response.body()?.d_mobile}</u>"
                    textDestinationAddress.value = "<b>Address </b><u>  ${response.body()?.d_address}</u>"
                 }
            }
        )
    }

}
