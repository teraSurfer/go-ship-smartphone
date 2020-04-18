package com.example.goship.ui.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.goship.R

//Holder or the recycler as part of the fragment
class OrderItemHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.fragment_order_item_list, parent, false)) {

//    private lateinit var binding: orderItemHolder

    private var mOrderId: TextView? = null
    private var mOrderDate: TextView? = null
    private var mOrderAtt1: TextView? = null
    private var mOrderAtt2: TextView? = null


    init {
        mOrderId =   itemView.findViewById(R.id.textOrderId)
        mOrderDate = itemView.findViewById(R.id.textDate)
        mOrderAtt1 = itemView.findViewById(R.id.textAttr1)
        mOrderAtt2 = itemView.findViewById(R.id.textAttr2)

        itemView?.setOnClickListener {
            //Future use
        }
    }

    fun bind(order: Orders) {
        mOrderId?.text =  HtmlCompat.fromHtml("<b>Order Id:</b>  ${order.orderId.toString()}" , HtmlCompat.FROM_HTML_MODE_COMPACT)
        mOrderDate?.text = HtmlCompat.fromHtml ("<b>${order.p_date}</b>" , HtmlCompat.FROM_HTML_MODE_COMPACT)
        mOrderAtt1?.text = HtmlCompat.fromHtml( "<b>Customer email:</b>  ${order.u_email}", HtmlCompat.FROM_HTML_MODE_COMPACT   )  //Customer: v_name   or vendor: u_email
        mOrderAtt2?.text =  HtmlCompat.fromHtml("<b>Price: </b>  $${order.price}", HtmlCompat.FROM_HTML_MODE_COMPACT)      //Customer: v_mobile r vendor: price
    }

}

