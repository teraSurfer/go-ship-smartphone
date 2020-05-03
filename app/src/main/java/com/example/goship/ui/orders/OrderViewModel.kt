package com.example.goship.ui.orders

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goship.dataproperty.*
import com.example.goship.network.ClientAllOrdersAPI
import com.example.goship.network.VendorAllOrdersAPI
import com.example.goship.ui.user.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OrderViewModel : ViewModel() {

    private val ordersFromAPI = HashMap<String, OrdersFromAPI>()
    val vmListOrders = MutableLiveData<List<OrdersFromAPI>>()
    val failureResponse = MutableLiveData<String>()
    val vmArraytId = MutableLiveData<Array<String>>()
    val q_email = MutableLiveData<String>()
    val userType = MutableLiveData<Int>()

    //private val _listOrders = MutableLiveData<List<OrdersFake>>().apply {
    //   value =  DataManager.customerOrders.values.toList()
    //}
    //val vmListOrders: LiveData<List<OrdersFake>> = _listOrders


    fun getVMOrderAdapterPosition(  position: Int) {
      //save previous position Not used yet
      val  myOrderPosition = position
        Log.i("OrderListAdapter", position.toString())
    }
//
//    init {
//        when (userType.value) {
//            1 -> getAllCustomerOrdersProperties()
//            2 -> getAllVendorOrdersProperties()
//            else -> failureResponse.value = "Unauthorized User"
//        }
//    }

    fun getAllVendorOrdersProperties() {
        VendorAllOrdersAPI.retrofitService.getProperties( q_email.value!!).enqueue(
            object: Callback<OrdersAll> {
                override fun onFailure(call: Call<OrdersAll>, t: Throwable ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    failureResponse.value = "Failure: " + t.message
                }
                override fun onResponse(call: Call<OrdersAll>, response: Response<OrdersAll>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    for (i in response.body()?.ordersPart?.indices!!){
                        val order =
                            OrdersFromAPI(
                                "<b>Order Id:</b> ${response.body()?.ordersPart?.get(i)?.id}",
                                "<b>${response.body()?.ordersPart?.get(i)?.p_date}</b>",
                                "<b>Client email:</b> ${response.body()?.ordersPart?.get(i)?.u_email}",
                                "<b>Price: </b>  $${response.body()?.ordersPart?.get(i)?.price}" )
                        ordersFromAPI.set(response.body()?.ordersPart?.get(i)?.id!!.toString(), order)    //Add to the HashMap in ordered by id
                    }
                    //Convert hasMap to an ArrayList
                    val idArraylist =  ArrayList(ordersFromAPI.keys)
                    //Convert ArrayList to an Array
                    //val myArray = arrayOfNulls<Long>(myArraylist.size)
                    val idArray = Array(idArraylist.size){" "}
                    idArraylist.toArray(idArray)
                    //send LiveData to the View
                    vmArraytId.value = idArray.copyOf()
                    vmListOrders.value = ordersFromAPI.values.toList()
                }
            }
        )
    }

    fun getAllCustomerOrdersProperties() {
        ClientAllOrdersAPI.retrofitService.getProperties( q_email.value!!).enqueue(
            object: Callback<OrdersAll> {
                override fun onFailure(call: Call<OrdersAll>, t: Throwable ) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    failureResponse.value = "Failure: " + t.message
                }
                override fun onResponse(call: Call<OrdersAll>, response: Response<OrdersAll>) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    for (i in response.body()?.ordersPart?.indices!!){
                        val order =
                            OrdersFromAPI(
                                "<b>Order Id:</b>  ${response.body()?.ordersPart?.get(i)?.id}",
                                "<b>${response.body()?.ordersPart?.get(i)?.p_date}</b>",
                                "<b>Vendor name:</b> ${response.body()?.ordersPart?.get(i)?.v_name}",
                                "<b>Phone: </b>  ${response.body()?.ordersPart?.get(i)?.v_mobile}" )
                        ordersFromAPI.set(response.body()?.ordersPart?.get(i)?.id!!.toString(), order)    //Add to the HashMap in ordered by id
                    }
                    //Convert hasMap to an ArrayList
                    val idArraylist =  ArrayList(ordersFromAPI.keys)
                    //Convert ArrayList to an Array
                    //val myArray = arrayOfNulls<Long>(myArraylist.size)
                    val idArray = Array(idArraylist.size){" "}
                    idArraylist.toArray(idArray)
                    //send LiveData to the View
                    vmArraytId.value = idArray.copyOf()
                    vmListOrders.value = ordersFromAPI.values.toList()

                }
            }
        )
    }


}

