package com.example.goship.ui.vendor.price

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.example.goship.R
import com.example.goship.databinding.FragmentShowLeastPriceBinding
import kotlinx.android.synthetic.main.fragment_show_least_price.view.*

class ShowLeastPriceFragment : Fragment() {

    private lateinit var showLeastPriceViewModel: ShowLeastPriceViewModel


    companion object {
        fun newInstance() = ShowLeastPriceFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShowLeastPriceBinding>(inflater, R.layout.fragment_show_least_price,container,false)

        showLeastPriceViewModel = ViewModelProviders.of(this).get(ShowLeastPriceViewModel::class.java)

        showLeastPriceViewModel.divisions.observe(viewLifecycleOwner, Observer { newdivisions ->
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item, newdivisions)
            (binding.sourceTextField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
            (binding.destinationTextField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        })

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        showLeastPriceViewModel = ViewModelProviders.of(this).get(ShowLeastPriceViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
