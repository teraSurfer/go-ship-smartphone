package com.example.goship.ui.orders

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.goship.R
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goship.databinding.FragmentOrderBinding
import com.example.goship.ui.orders.recycleradapter.OrderListAdapter
import com.example.goship.ui.user.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*


class OrderFragment : Fragment() {

    companion object {
        fun newInstance() = OrderFragment()
    }

    private lateinit var orderViewModel: OrderViewModel
    private lateinit var binding: FragmentOrderBinding
    private lateinit var ordersId: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val menu  = activity?.nav_view?.menu;

        orderViewModel =
            ViewModelProvider(this).get(OrderViewModel::class.java)
        val loginViewModel : LoginViewModel by activityViewModels()
        orderViewModel.q_email.value = loginViewModel.email.value.toString()
        if (loginViewModel.isCustomer.value!!){
            orderViewModel.getAllCustomerOrdersProperties()
            if (menu != null) {
                menu.findItem(R.id.nav_vendor_estimate).isVisible = false
                menu.findItem(R.id.nav_customer_estimate).isVisible = true
            }
        }else{
            orderViewModel.getAllVendorOrdersProperties()
            if (menu != null) {
                menu.findItem(R.id.nav_vendor_estimate).isVisible = true
                menu.findItem(R.id.nav_customer_estimate).isVisible = false
            }
        }

        binding = DataBindingUtil.inflate<FragmentOrderBinding>(inflater,
            R.layout.fragment_order, container, false)

        orderViewModel.vmArraytId.observe(viewLifecycleOwner, Observer {
            ordersId = it.copyOf()
        })

        orderViewModel.vmListOrders.observe(viewLifecycleOwner, Observer {
            binding.ordersCustomerList.apply {
                // set a LinearLayoutManager to handle Android
                // RecyclerView behavior
                layoutManager = activity?.let { it1 -> LinearLayoutManager(it1) }
                // set the custom adapter to the RecyclerView
                adapter = OrderListAdapter(it, orderViewModel, ordersId)
            }
        })

        orderViewModel.failureResponse.observe(viewLifecycleOwner, Observer {
            Toast.makeText(getContext(),
                "Network Error: ${it}", Toast.LENGTH_LONG).show()
        })

        orderViewModel.vmNoDAta.observe(viewLifecycleOwner, Observer {
            binding.textNoData.setText("No Order Placed")
            binding.textNoData.visibility = it
        })

        setHasOptionsMenu(true)

        return  binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        orderViewModel = ViewModelProvider(this).get(orderViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(view!!))
                ||super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.main, menu)
        menu[0].setVisible(true)
    }

}
