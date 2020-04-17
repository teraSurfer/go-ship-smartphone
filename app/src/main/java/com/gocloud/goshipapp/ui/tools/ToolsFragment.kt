package com.gocloud.goshipapp.ui.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentToolsBinding

class ToolsFragment : Fragment() {

    private lateinit var toolsViewModel: ToolsViewModel
    private lateinit var binding: FragmentToolsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /***With ViewModelFactory***/
        //val viewModel = ViewModelProvider(this, YourViewModelFactory).get(YourViewModel::class.java)
        /***Without ViewModelFactory***/
        //val viewModel = ViewModelProvider(this).get(YourViewModel::class.java)

        toolsViewModel =
            ViewModelProvider(this).get(ToolsViewModel::class.java)
            //ViewModelProviders.of(this).get(ToolsViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentToolsBinding>(inflater,
            R.layout.fragment_tools, container, false)

        val textView: TextView = binding.textTools
        toolsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }
}