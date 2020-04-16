package com.gocloud.goshipapp.ui.share

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gocloud.goshipapp.R

class ChatbotFragment : Fragment() {

    private lateinit var chatbotViewModel: ChatbotViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatbotViewModel =
            ViewModelProviders.of(this).get(ChatbotViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chatbot, container, false)
        val textView: TextView = root.findViewById(R.id.text_share)
        chatbotViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}