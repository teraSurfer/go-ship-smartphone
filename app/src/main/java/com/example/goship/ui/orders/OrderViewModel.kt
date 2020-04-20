package com.example.goship.ui.orders

import android.util.Log
import androidx.core.text.HtmlCompat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goship.dataproperty.*
import com.example.goship.network.OrdersClientAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderViewModel : ViewModel() {

    val ordersFromAPI = HashMap<Long, OrdersFromAPI>()
    val failureResponse = MutableLiveData<String>()


    private val _listOrders = MutableLiveData<List<OrdersFromAPI>>().apply {
        value =  ordersFromAPI.values.toList()
    }
    val vmListOrders: MutableLiveData<List<OrdersFromAPI>> = _listOrders

//DELETE
//    private val _listOrders = MutableLiveData<List<OrdersFake>>().apply {
//        value =  DataManager.customerOrders.values.toList()
//    }
//    val vmListOrders: LiveData<List<OrdersFake>> = _listOrders


    fun getVMOrderAdapterPosition(  position: Int) {
      //save previous position Not used yet
      val  myOrderPosition = position
        Log.i("OrderListAdapter", position.toString())
    }

    init {
        when (userType) {
            1 -> getCustomersOrdersProperties()
            2 -> getVendorsOrdersProperties()
            else -> { // Note the block
                print("Unauthorized User")
            }
        }
    }

    private fun getVendorsOrdersProperties() {
        OrdersClientAPI.retrofitService.getProperties( q_email!!).enqueue(
            object: Callback<OrdersProperty> {
                override fun onFailure(call: Call<OrdersProperty>, t: Throwable ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    failureResponse.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<OrdersProperty>, response: Response<OrdersProperty>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    for (i in response.body()?.ordersPart?.indices!!){
                        var order =
                            OrdersFromAPI(
                                "<b>Order Id:</b>  ${response.body()?.ordersPart?.get(i)?.ID}",
                                "<b>${response.body()?.ordersPart?.get(i)?.P_Date}</b>",
                                "<b>Client email:</b> ${response.body()?.ordersPart?.get(i)?.U_Email}",
                                "<b>Price: </b>  $${response.body()?.ordersPart?.get(i)?.Price}" )
                        ordersFromAPI.set(response.body()?.ordersPart?.get(i)?.ID!!, order)    //Add to the HashMap in ordered by id
                    }
                    vmListOrders.value = ordersFromAPI.values.toList()
                }
            }
        )
    }

    private fun getCustomersOrdersProperties() {
        OrdersClientAPI.retrofitService.getProperties( q_email!!).enqueue(
            object: Callback<OrdersProperty> {
                override fun onFailure(call: Call<OrdersProperty>, t: Throwable ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    failureResponse.value = "Failure: " + t.message
                }

                override fun onResponse(call: Call<OrdersProperty>, response: Response<OrdersProperty>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    for (i in response.body()?.ordersPart?.indices!!){
                        var order =
                            OrdersFromAPI(
                                "<b>Order Id:</b>  ${response.body()?.ordersPart?.get(i)?.ID}",
                                "<b>${response.body()?.ordersPart?.get(i)?.P_Date}</b>",
                                "<b>Vendor name:</b> ${response.body()?.ordersPart?.get(i)?.V_Name}",
                                "<b>Phone: </b>  ${response.body()?.ordersPart?.get(i)?.V_Mobile}" )
                        ordersFromAPI.set(response.body()?.ordersPart?.get(i)?.ID!!, order)    //Add to the HashMap in ordered by id
                    }
                    vmListOrders.value = ordersFromAPI.values.toList()
                }
            }
        )
    }


}

