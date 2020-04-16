package com.gocloud.goshipapp.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gocloud.goshipapp.R

class ShippingPricesFragment : Fragment() {

    private lateinit var shippingPricesViewModel: ShippingPricesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shippingPricesViewModel =
            ViewModelProviders.of(this).get(ShippingPricesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_shippingprices, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        shippingPricesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}