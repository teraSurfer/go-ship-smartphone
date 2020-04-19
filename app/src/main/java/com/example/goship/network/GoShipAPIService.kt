package com.example.goship.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import com.example.goship.dataproperty.DivisionProperty
import com.example.goship.dataproperty.OrdersProperty
import retrofit2.http.Query

//private const val BASE_URL = "http://10.0.2.2"
private const val BASE_URL = "https://api.cmpe282.terasurfer.com/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Scalar converter
 * want Retrofit to fetch a JSON response from the REST API, and return it as a String
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


/**
 * A public interface that exposes the [getProperties] method
 */
interface GetDivisionService {
    @GET("/divisions") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(): Call<DivisionProperty>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 * each time your app calls WeatherApi.retrofitService, it will get a singleton Retrofit object that implements ApiService.
 */
object DivisionAPI {
    val retrofitService : GetDivisionService by lazy {
        retrofit.create(GetDivisionService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}



/*****************API FOR ORDERS****************************************
 * A public interfaces that exposes the [getProperties] method
 */
interface GetClientOrdersService {
    @GET("/orders") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("u_email") u_email: String):
            Call<OrdersProperty>
}
interface GetVendorOrdersService {
    @GET("/orders") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("v_email") v_email: String):
            Call<OrdersProperty>
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 * each time your app calls WeatherApi.retrofitService, it will get a singleton Retrofit object that implements ApiService.
 */
object OrdersClientAPI {
    val retrofitService : GetClientOrdersService by lazy {
        retrofit.create(GetClientOrdersService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}
object OrdersVendorAPI {
    val retrofitService : GetClientOrdersService by lazy {
        retrofit.create(GetClientOrdersService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}
/****************END orders API*****************************************/