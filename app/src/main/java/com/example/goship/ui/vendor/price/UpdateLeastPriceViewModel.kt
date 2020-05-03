package com.example.goship.ui.vendor.price

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.goship.dataproperty.DivisionProperty
import com.example.goship.dataproperty.LeastPriceProperty
import com.example.goship.network.DivisionAPI
import com.example.goship.network.LeastPriceAPI
import com.example.goship.network.UpdateLeastPriceAPI
import com.example.goship.network.UpdateLeastPriceService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateLeastPriceViewModel : ViewModel() {

    val leastprice = MutableLiveData<Int>()
    val initialprice = MutableLiveData<Int>()
    val sourcedivision = MutableLiveData<String>()
    val destinationdivision = MutableLiveData<String>()


    /**
     * Call getLeastPrice() on init so we can display status immediately.
     */
    init {
        leastprice.value = 0
        initialprice.value = 0
        sourcedivision.value = ""
        destinationdivision.value = ""

    }

    public fun getLeastPrice(source: String, destination: String) {

        LeastPriceAPI.retrofitService.getProperties(source_division = source, destination_division = destination).enqueue(
            object : Callback<LeastPriceProperty> {
                override fun onFailure(call: Call<LeastPriceProperty>, t: Throwable) {
                    leastprice.value = 0
                }

                override fun onResponse(
                    call: Call<LeastPriceProperty>,
                    response: Response<LeastPriceProperty>
                ) {
                    leastprice.value = (response.body()?.least_price?.toInt())
                    initialprice.value = leastprice.value
                }
            }
        )
    }

    fun increasePrice() {
        if  (leastprice.value != initialprice.value){
            leastprice.value = (leastprice.value)?.plus(1)
        }
     }

    fun decreasePrice() {
        if  (leastprice.value != 0){
            leastprice.value = (leastprice.value)?.minus(1)
        }

     }
}
