package com.example.goship.dataproperty

import com.squareup.moshi.Json

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