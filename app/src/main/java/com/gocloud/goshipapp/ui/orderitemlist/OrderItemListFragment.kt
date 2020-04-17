//package com.gocloud.goshipapp.ui.orderitemlist
//
//import androidx.lifecycle.ViewModelProviders
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//
//import com.gocloud.goshipapp.R
//
//class OrderItemListFragment : Fragment() {
//
//    companion object {
//        fun newInstance() = OrderItemListFragment()
//    }
//
//    private lateinit var viewModel: OrderItemListViewModel
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.fragment_order_item_list_old, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(OrderItemListViewModel::class.java)
//        // TODO: Use the ViewModel
//    }
//
//}
