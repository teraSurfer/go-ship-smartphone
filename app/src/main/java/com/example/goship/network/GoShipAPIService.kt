package com.example.goship.network


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import com.example.goship.dataproperty.DivisionProperty

private const val BASE_URL = "http://10.0.2.2"

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