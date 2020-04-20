package com.example.goship.ui.orders.orderdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.goship.R
import com.example.goship.databinding.FragmentOrderDetailsBinding
import android.widget.ArrayAdapter
import androidx.core.text.HtmlCompat



class OrderDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = OrderDetailsFragment()
    }

    private lateinit var orderDetailsViewModel: OrderDetailsViewModel
    private lateinit var binding: FragmentOrderDetailsBinding
    private var orderPosition: Int = 0
    private var orderMaxPosition: Int = 0
    private lateinit var ordersList: Array<String>

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        orderDetailsViewModel =
            ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_order_details, container, false)


        orderDetailsViewModel.vmTtextSelectIdLabel.observe(viewLifecycleOwner, Observer{
            binding.textSelectIdLabel.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextVendorLabel.observe(viewLifecycleOwner, Observer{
            binding.textVendorLabel.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextShipLabel.observe(viewLifecycleOwner, Observer{
            binding.textShipLabel.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextOriginLabel.observe(viewLifecycleOwner, Observer{
            binding.textOriginLabel.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextDestinationLabel.observe(viewLifecycleOwner, Observer{
            binding.textDestinationLabel.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextOrderId.observe(viewLifecycleOwner, Observer{
            binding.textOrderId.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextOrderPosition.observe(viewLifecycleOwner, Observer{
            binding.textOrderPosition.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmSpCities.observe(viewLifecycleOwner, Observer {
            orderMaxPosition = it.size - 1
            val adapterOrdersId = ArrayAdapter<String>(requireContext(),
                android.R.layout.simple_list_item_1,
                it)
            binding.spinnerId.adapter = adapterOrdersId
            adapterOrdersId.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerId.setSelection(orderPosition)
            orderDetailsViewModel.getVMOrderSelected(binding.spinnerId.selectedItem)

        })


        binding.spinnerId.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Do nothing
            }
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                orderPosition = p2
                //val aaa= binding.spinnerCities.getItemIdAtPosition(cityPosition)
                orderDetailsViewModel.getVMOrderPosition(orderPosition)
                orderDetailsViewModel.getVMOrderSelected(binding.spinnerId.selectedItem)
            }
        }

        binding.fabRight.setOnClickListener {viewLifecycleOwner
            orderPosition = orderPosition + 1
            if ( orderMaxPosition < orderPosition )  orderPosition = 0
            orderDetailsViewModel.getVMOrderPosition(orderPosition)
            binding.spinnerId.setSelection(orderPosition)
            orderDetailsViewModel.getVMOrderSelected(binding.spinnerId.selectedItem)
        }

        binding.fabLeft.setOnClickListener {viewLifecycleOwner
            orderPosition = orderPosition - 1
            if ( orderPosition < 0 )  orderPosition = orderMaxPosition
            orderDetailsViewModel.getVMOrderPosition(orderPosition)
            binding.spinnerId.setSelection(orderPosition)
            orderDetailsViewModel.getVMOrderSelected(binding.spinnerId.selectedItem)
        }

        orderDetailsViewModel.vmTextClientEmail.observe(viewLifecycleOwner, Observer{
            binding.textClientEmail.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextVendorName.observe(viewLifecycleOwner, Observer{
            binding.textVendorName.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextVendorPhone.observe(viewLifecycleOwner, Observer{
            binding.textVendorPhone.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextVendorEmail.observe(viewLifecycleOwner, Observer{
            binding.textVendorEmail.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextPrice.observe(viewLifecycleOwner, Observer{
            binding.textPrice.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.vmTextWeight.observe(viewLifecycleOwner, Observer{
            binding.textWeight.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.textOrigenDate.observe(viewLifecycleOwner, Observer{
            binding.textOrigenDate.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.textOrigenMobile.observe(viewLifecycleOwner, Observer{
            binding.textOrigenMobile.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.textOrigenAddress.observe(viewLifecycleOwner, Observer{
            binding.textOrigenAddress.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.textPickDate.observe(viewLifecycleOwner, Observer{
            binding.textPickDate.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.textDestinationMobile.observe(viewLifecycleOwner, Observer{
            binding.textDestinationMobile.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })

        orderDetailsViewModel.textDestinationAddress.observe(viewLifecycleOwner, Observer{
            binding.textDestinationAddress.setText(HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_COMPACT))
        })


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        orderDetailsViewModel = ViewModelProvider(this).get(OrderDetailsViewModel::class.java)
        // TODO: Use the ViewModel
        orderPosition = OrderDetailsFragmentArgs.fromBundle(arguments!!).orderPosition
        ordersList = OrderDetailsFragmentArgs.fromBundle(arguments!!).ordersIDs
        orderDetailsViewModel.getVMOrderPosition(orderPosition)
        orderDetailsViewModel.getVMOrderIDs(ordersList)
    }

}
