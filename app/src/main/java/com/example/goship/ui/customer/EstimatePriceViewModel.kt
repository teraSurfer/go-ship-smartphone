package com.example.goship.ui.customer

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goship.network.PincodeAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.goship.dataproperty.CityProperty
import com.example.goship.dataproperty.LeastPriceProperty

class EstimatePriceViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    val source_city = MutableLiveData<String>()
    val destiantion_city = MutableLiveData<String>()

    init {
        source_city.value = ""
        destiantion_city.value = ""
    }

    public fun getSourceCity(source_zip: String){
        PincodeAPI.retrofitService.getProperties(pincode = source_zip).enqueue(
            object : Callback<CityProperty> {
                override fun onFailure(call: Call<CityProperty>, t: Throwable) {
                    source_city.value = "Invalid Source zipcode"
                }

                override fun onResponse(
                    call: Call<CityProperty>,
                    response: Response<CityProperty>
                ) {
                    if(!response.isSuccessful)
                        source_city.value = "Invalid Source zipcode"
                    else
                        source_city.value = "Source City: " + response.body()?.brnm
                }
            }
        )
    }

    public fun getDestinationCity(destination_zip: String){
        PincodeAPI.retrofitService.getProperties(pincode = destination_zip).enqueue(
            object : Callback<CityProperty> {
                override fun onFailure(call: Call<CityProperty>, t: Throwable) {
                    destiantion_city.value = "Invalid Destination zipcode"
                }

                override fun onResponse(
                    call: Call<CityProperty>,
                    response: Response<CityProperty>
                ) {
                    if(!response.isSuccessful)
                        destiantion_city.value = "Invalid Destination zipcode"
                    else
                        destiantion_city.value = "Destination City: " + response.body()?.brnm
                }
            }
        )
    }



}
