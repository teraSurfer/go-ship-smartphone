package com.example.goship.ui.customer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

import com.example.goship.R
import com.example.goship.databinding.FragmentEstimatePriceBinding

class EstimatePriceFragment : Fragment() {

    companion object {
        fun newInstance() = EstimatePriceFragment()
    }

    private lateinit var viewModel: EstimatePriceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EstimatePriceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}


