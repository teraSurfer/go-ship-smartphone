package com.gocloud.goshipapp.ui.send

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentSendBinding

class SendFragment : Fragment() {

    private lateinit var sendViewModel: SendViewModel
    private lateinit var binding: FragmentSendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sendViewModel =
            ViewModelProvider(this).get(SendViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentSendBinding>(inflater,
            R.layout.fragment_send, container, false)

        sendViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textSend.text = it
        })

        return binding.root
    }
}