package com.example.goship.ui.vendor.price

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

import com.example.goship.R
import com.example.goship.databinding.FragmentShowLeastPriceBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_show_least_price.view.*

class ShowLeastPriceFragment : Fragment() {

    private lateinit var showLeastPriceViewModel: ShowLeastPriceViewModel


//    companion object {
//        fun newInstance() = ShowLeastPriceFragment()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val menu  = activity?.nav_view?.menu;
        if (menu != null) {
            menu.findItem(R.id.nav_customer_estimate).isVisible = false
            menu.findItem(R.id.nav_vendor_estimate).isVisible = true
        }
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.visibility  = View.VISIBLE

        val binding = DataBindingUtil.inflate<FragmentShowLeastPriceBinding>(inflater, R.layout.fragment_show_least_price,container,false)

        showLeastPriceViewModel = ViewModelProviders.of(this).get(ShowLeastPriceViewModel::class.java)

        binding.sourceAutoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            showLeastPriceViewModel.sourcedivision.value = showLeastPriceViewModel.divisions.value!![position]
        }

        binding.destinationAutoCompleteTextView.setOnItemClickListener { _, _, position, _ ->
            showLeastPriceViewModel.destinationdivision.value = showLeastPriceViewModel.divisions.value!![position]
        }

        showLeastPriceViewModel.divisions.observe(viewLifecycleOwner, Observer { newdivisions ->
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, newdivisions)
            (binding.sourceTextField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            (binding.destinationTextField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        })

        binding.vendorGetPriceButtonId.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(
                ShowLeastPriceFragmentDirections.actionNavVendorEstimateToUpdateLeastPriceFragment(sourcedivision = binding.sourceAutoCompleteTextView.text.toString(), destinationdivision = binding.destinationAutoCompleteTextView.text.toString())
            )
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showLeastPriceViewModel = ViewModelProviders.of(this).get(ShowLeastPriceViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, Navigation.findNavController(view!!))
                ||super.onOptionsItemSelected(item)
    }

}
