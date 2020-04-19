package com.example.goship.ui.vendor.price

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goship.dataproperty.DivisionProperty
import com.example.goship.network.DivisionAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowLeastPriceViewModel : ViewModel() {

    val divisions = MutableLiveData<List<String>>()
    val sourcedivision = MutableLiveData<String>()
    val destinationdivision = MutableLiveData<String>()

    /**
     * Call getDivisions() on init so we can display status immediately.
     */
    init {
        getDivisions()
        sourcedivision.value = ""
        destinationdivision.value = ""
    }

    private fun getDivisions() {

        DivisionAPI.retrofitService.getProperties().enqueue(
            object : Callback<DivisionProperty> {
                override fun onFailure(call: Call<DivisionProperty>, t: Throwable) {
                    divisions.value = listOf("Error").toList()
                }

                override fun onResponse(
                    call: Call<DivisionProperty>,
                    response: Response<DivisionProperty>
                ) {
                    divisions.value = (response.body()?.divisions)?.toList()
                }

            }
        )
    }
}