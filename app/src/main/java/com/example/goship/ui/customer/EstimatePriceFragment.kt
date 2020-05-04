package com.example.goship.ui.customer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import com.example.goship.R
import com.example.goship.databinding.FragmentEstimatePriceBinding
import kotlinx.android.synthetic.main.activity_main.*

class EstimatePriceFragment : Fragment() {

    companion object {
        fun newInstance() = EstimatePriceFragment()
    }

    private lateinit var viewModel: EstimatePriceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val menu  = activity?.nav_view?.menu;
        if (menu != null) {
            menu.findItem(R.id.nav_vendor_estimate).isVisible = false
            menu.findItem(R.id.nav_customer_estimate).isVisible = true
        }
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.visibility  = View.VISIBLE

        val binding = DataBindingUtil.inflate<FragmentEstimatePriceBinding>(inflater, R.layout.fragment_estimate_price,container,false)

        viewModel = ViewModelProviders.of(this).get(EstimatePriceViewModel::class.java)

        binding.sourceCity.text = viewModel.source_city.value
        binding.destinationCity.text = viewModel.destiantion_city.value

        binding.sourceZip.setOnFocusChangeListener { view, hasFocus ->

            if (hasFocus == false){
                viewModel.getSourceCity(binding.sourceZip.text.toString())
            }
        }
        binding.destinationZip.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus == false) {
                viewModel.getDestinationCity(binding.destinationZip.text.toString())
            }
        }

        binding.customerGetPriceButtonId.setOnClickListener {view: View ->

            if(binding.sourceCity.text.toString().trim().startsWith("Invalid") || binding.sourceCity.text.toString().trim().equals("") ||
                binding.destinationCity.text.toString().trim().startsWith("Invalid") || binding.destinationCity.text.toString().trim().equals("")||
                    binding.weight.text.toString().trim().equals("")){

            }else {
                var action =
                    EstimatePriceFragmentDirections.actionNavCustomerEstimateToNavPlaceOrder(
                        source = binding.sourceZip.text.toString(),
                        destination = binding.destinationZip.text.toString(),
                        weight = binding.weight.text.toString().toInt()
                    )
                view.findNavController().navigate(action)
            }
        }

        viewModel.source_city.observe(viewLifecycleOwner, Observer {
            binding.sourceCity.text = viewModel.source_city.value

        })

        viewModel.destiantion_city.observe(viewLifecycleOwner, Observer {
            binding.destinationCity.text = viewModel.destiantion_city.value
        })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EstimatePriceViewModel::class.java)
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


