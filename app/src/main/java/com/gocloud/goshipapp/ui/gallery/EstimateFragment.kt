package com.gocloud.goshipapp.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gocloud.goshipapp.R

class EstimateFragment : Fragment() {

    private lateinit var estimateViewModel: EstimateViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        estimateViewModel =
            ViewModelProviders.of(this).get(EstimateViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_estimate, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        estimateViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}