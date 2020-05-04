package com.example.goship.network


import com.example.goship.dataproperty.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST


//private const val BASE_URL = "http://10.0.2.2:3000"
private const val BASE_URL = "https://api.cmpe282.terasurfer.com"

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
        retrofit.create(GetDivisionService::class.java)
    }
}

interface GetLeastPriceService {
    @GET("/leastcost") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("sourcedivision") source_division: String,
                      @Query("destinationdivision") destination_division: String
    ): Call<LeastPriceProperty>
}

object LeastPriceAPI {
    val retrofitService : GetLeastPriceService by lazy {
        retrofit.create(GetLeastPriceService::class.java)
    }
}

interface LoginService {
    @POST("/login") //realestate Retrofit appends the endpoint to the base URL
    fun post(@Body request: RequestBody
    ): Call<ResponseBody>
}

object LoginAPI {
    val retrofitService : LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }
}

interface AddCustomerService {
    @POST("/adduser") //realestate Retrofit appends the endpoint to the base URL
    fun post(@Body request: RequestBody
    ): Call<ResponseBody>
}

object AddCustomerAPI {
    val retrofitService : AddCustomerService by lazy {
        retrofit.create(AddCustomerService::class.java)
    }
}

interface AddVendorService {
    @POST("/addvendor") //realestate Retrofit appends the endpoint to the base URL
    fun post(@Body request: RequestBody
    ): Call<ResponseBody>
}

object AddVendorAPI {
    val retrofitService : AddVendorService by lazy {
        retrofit.create(AddVendorService::class.java)
    }
}

interface PincodeService {
    @GET("/pincode") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("pincode") pincode: String
    ): Call<CityProperty>
}

object PincodeAPI {
    val retrofitService : PincodeService by lazy {
        retrofit.create(PincodeService::class.java)
    }
}


interface EstimateService {
    @GET("/estimate") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("origin") source: String,
                      @Query("destination") destination: String,
                      @Query("weight") weight: Int
    ): Call<EstimateProperty>
}

object EstimateAPI {
    val retrofitService : EstimateService by lazy {
        retrofit.create(EstimateService::class.java)
    }
}


interface PlaceOrderService {
    @POST("/placeorder") //realestate Retrofit appends the endpoint to the base URL
    fun post(@Body request: RequestBody
    ): Call<OrderSuccessProperty>
}

object PlaceOrderAPI {
    val retrofitService : PlaceOrderService by lazy {
        retrofit.create(PlaceOrderService::class.java)
    }
}

interface UpdateLeastPriceService {
    @POST("/updateprice") //realestate Retrofit appends the endpoint to the base URL
    fun post(@Body request: RequestBody
    ): Call<ResponseBody>
}

object UpdateLeastPriceAPI {
    val retrofitService : UpdateLeastPriceService by lazy {
        retrofit.create(UpdateLeastPriceService::class.java)
    }
}



/*****************API FOR ORDERS****************************************
 * A public interfaces that exposes the [getProperties] method
 */
//Set orders from client
interface GetClientAllOrdersService {
    @GET("/orders") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("u_email") u_email: String):
            Call<OrdersAll>
}
/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 * each time your app calls WeatherApi.retrofitService, it will get a singleton Retrofit object that implements ApiService.
 */
object
ClientAllOrdersAPI {
    val retrofitService : GetClientAllOrdersService by lazy {
        retrofit.create(GetClientAllOrdersService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}

//Set orders from vendor**
interface GetVendorAllOrdersService {
    @GET("/orders") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("v_email") v_email: String):
            Call<OrdersAll>
}
object VendorAllOrdersAPI {
    val retrofitService : GetVendorAllOrdersService by lazy {
        retrofit.create(GetVendorAllOrdersService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}

//Single order get for vendor or customer**
interface GetOrderService {
    @GET("/order") //realestate Retrofit appends the endpoint to the base URL
    fun getProperties(@Query("id") id: String
    ):Call<OrderSingle>
}
object OrderAPI {
    val retrofitService : GetOrderService by lazy {
        retrofit.create(GetOrderService::class.java) }
    //The Retrofit create() method creates the Retrofit service itself with the ApiService interface.
}
/****************END orders API*****************************************/