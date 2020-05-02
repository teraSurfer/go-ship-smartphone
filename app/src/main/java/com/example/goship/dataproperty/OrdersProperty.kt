package com.example.goship.dataproperty

import com.squareup.moshi.Json

//https://api.cmpe282.terasurfer.com/orders?v_email=amit.vijapure@sjsu.edu
data class OrdersAll(
    @Json(name = "orders") val ordersPart : List<OrdersParts>
)

data class OrdersParts (
    val v_mobile: String,
    val o_address: String,
    val weight: Int,
    val v_email: String,
    val origin: Int,
    val destination: Int,
    val d_mobile: String,
    val d_address: String,
    val o_date: String,
    val current_status: String,
    val o_mobile: String,
    val v_name: String,
    val price: Int,
    val p_date: String,
    val id: Long,
    val u_email: String
)

data class OrderSingle(
    val v_mobile: String,
    val o_address: String,
    val weight: Int,
    val v_email: String,
    val origin: Int,
    val destination: Int,
    val d_mobile: String,
    val d_address: String,
    val o_date: String,
    val current_status: String,
    val o_mobile: String,
    val v_name: String,
    val price: Int,
    val p_date: String,
    val id: Long,
    val u_email: String
)

data class OrdersFromAPI (val id: String, val p_date: String, val uemail_vname: String, val price_vmobile: String) {}

//val q_email : String = "amit.vijapure@sjsu.edu"
//val userType: Int = 2    //0: Not set,  1:Customer,  2: Vendors
val q_email : String = "sergio.aguilarcama@sjsu.edu"
//val q_email : String = "achalaesh.lanka@sjsu.edu"
val userType: Int = 1    //0: Not set,  1:Customer,  2: Vendors


/*******JSON sample****************/
//https://api.cmpe282.terasurfer.com/order?u_email=amit.vijapure@sjsu.edu&id=1587323181637
//data class OrderProperty(
//    @Json(name = "orders") val ordersPart : List<OrdersPart>
//)
//
//data class OrdersPart (
//    val V_Mobile: String,
//    val O_Address: String,
//    val Weight: Int,
//    val V_Email: String,
//    val Origin: Int,
//    val Destination: Int,
//    val D_Mobile: String,
//    val D_Address: String,
//    val O_Date: String,
//    val Current_Status: String,
//    val O_Mobile: String,
//    val V_Name: String,
//    val Price: Int,
//    val P_Date: String,
//    val ID: Long,
//    val U_Email: String
//)




