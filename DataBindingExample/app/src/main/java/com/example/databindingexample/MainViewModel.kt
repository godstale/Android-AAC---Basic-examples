package com.example.databindingexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {
    val TAG = "MainViewModel"
    private var count = 0
    val countText : MutableLiveData<String> = MutableLiveData()

    fun init() {
        countText.value = "click count : $count"
    }

    fun clickButton() {
        countText.value = "click count : ${++count}"
    }

    override fun onCleared() {
        Log.d(TAG, "## MainViewModel - onCleared() called!!")
        Log.d(TAG, "## count = $count")
        super.onCleared()
    }
}
