package com.gocloud.goshipapp.ui.estimate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstimateViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Estimate Fragment"
    }
    val text: LiveData<String> = _text
}