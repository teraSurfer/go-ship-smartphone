package com.gocloud.goshipapp.ui.share

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatbotViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is chatbot Fragment"
    }
    val text: LiveData<String> = _text
}