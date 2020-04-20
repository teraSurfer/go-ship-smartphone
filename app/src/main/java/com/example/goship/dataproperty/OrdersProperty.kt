package com.example.goship.dataproperty

import com.squareup.moshi.Json


data class OrdersProperty(
    @Json(name = "orders") val ordersPart : List<OrdersPart>
)

data class OrdersPart (
    val V_Mobile: String,
    val O_Address: String,
    val Weight: Int,
    val V_Email: String,
    val Origin: Int,
    val Destination: Int,
    val D_Mobile: String,
    val D_Address: String,
    val O_Date: String,
    val Current_Status: String,
    val O_Mobile: String,
    val V_Name: String,
    val Price: Int,
    val P_Date: String,
    val ID: Long,
    val U_Email: String
)

data class OrdersFromAPI (val id: String, val p_date: String, val uemail_vname: String, val price_vmobile: String) {}

val q_email : String = "amit.vijapure@sjsu.edu"

val userType: Int = 1    //0: Not set,  1:Customer,  2: Vendors


//"V_Mobile": 5034343434,
//"O_Address": "Pune",
//"Weight": 65,
//"V_Email": "amit.vijapure@sjsu.edu",
//"Origin": 125033,
//"Destination": 411057,
//"D_Mobile": 5554343453,
//"D_Address": "Banglore",
//"O_Date": "2020-04-19 19:06:44.434275",
//"Current_Status": "Accepted",
//"O_Mobile": 4646432323,
//"V_Name": "Amit",
//"Price": 585,
//"P_Date": "10/10/2019",
//"ID": 1587323204357,
//"U_Email": "amit.vijapure@sjsu.edu"