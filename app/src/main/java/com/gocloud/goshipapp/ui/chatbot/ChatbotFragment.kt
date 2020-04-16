package com.gocloud.goshipapp.ui.chatbot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gocloud.goshipapp.R
import com.gocloud.goshipapp.databinding.FragmentChatbotBinding

class ChatbotFragment : Fragment() {

    private lateinit var chatbotViewModel: ChatbotViewModel
    private lateinit var binding: FragmentChatbotBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatbotViewModel =
            ViewModelProvider(this).get(ChatbotViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentChatbotBinding>(inflater,
            R.layout.fragment_chatbot, container, false )

        chatbotViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textChatbot.text = it
        })
        return binding.root
    }
}