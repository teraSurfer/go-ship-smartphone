package com.example.goship.ui.orders.recycleradapter

import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.goship.databinding.FragmentOrderItemListBinding
import com.example.goship.ui.orders.Orders

//Holder or the recycler as part of the Orders fragment
class OrderItemHolder(val binding: FragmentOrderItemListBinding) :
    RecyclerView.ViewHolder(binding.root) {



    private var mOrderId: TextView? = null
    private var mOrderDate: TextView? = null
    private var mOrderAtt1: TextView? = null
    private var mOrderAtt2: TextView? = null


    init {
        mOrderId =   binding.textOrderId
        mOrderDate = binding.textDate
        mOrderAtt1 = binding.textAttr1
        mOrderAtt2 = binding.textAttr2
    }

    fun bind(order: Orders) {
        mOrderId?.text =  HtmlCompat.fromHtml("<b>Order Id:</b>  ${order.orderId.toString()}" , HtmlCompat.FROM_HTML_MODE_COMPACT)
        mOrderDate?.text = HtmlCompat.fromHtml ("<b>${order.p_date}</b>" , HtmlCompat.FROM_HTML_MODE_COMPACT)
        mOrderAtt1?.text = HtmlCompat.fromHtml( "<b>Customer email:</b>  ${order.u_email}", HtmlCompat.FROM_HTML_MODE_COMPACT   )  //Customer: v_name   or vendor: u_email
        mOrderAtt2?.text =  HtmlCompat.fromHtml("<b>Price: </b>  $${order.price}", HtmlCompat.FROM_HTML_MODE_COMPACT)      //Customer: v_mobile r vendor: price
    }

}

