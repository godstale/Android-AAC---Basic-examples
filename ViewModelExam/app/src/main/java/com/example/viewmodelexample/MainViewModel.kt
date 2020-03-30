package com.example.viewmodelexample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Basic view model example
 */
class MainViewModel : ViewModel() {
    val TAG = "MainViewModel"
    private var count = 0

    fun getCountText(): String {
        return "click count : $count"
    }

    fun clickButton(): String {
        return "click count : ${++count}"
    }

    override fun onCleared() {
        Log.d(TAG, "## MainViewModel - onCleared() called!!")
        Log.d(TAG, "## count = $count")
        super.onCleared()
    }
}

/**
 * Custom view model example
 */
class CustomViewModel(var count: Int) : ViewModel() {
    val TAG: String = "CustomViewModel"

    fun getCountText(): String {
        return "click count : $count"
    }

    fun clickButton(): String {
        return "click count : ${++count}"
    }

    override fun onCleared() {
        Log.d(TAG, "## CustomViewModel - onCleared() called!!")
        Log.d(TAG, "## count = $count")
        super.onCleared()
    }
}

class CustomViewModelFactory(val count: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomViewModel::class.java)) {
            return CustomViewModel(count) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}