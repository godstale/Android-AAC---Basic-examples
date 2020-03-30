package com.example.viewmodelexam

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Basic view model example
 */
class MainViewModel : ViewModel() {
    val TAG = "MainViewModel"
    var userText = "view model 1"

    override fun onCleared() {
        userText = ""
        Log.d(TAG, "## MainViewModel - onCleared() called!!")
        Log.d(TAG, "## userText = $userText")
        super.onCleared()
    }
}

/**
 * Custom view model example
 */
class CustomViewModel(var userText: String) : ViewModel() {
    val TAG: String = "CustomViewModel"

    override fun onCleared() {
        userText = ""
        Log.d(TAG, "## CustomViewModel - onCleared() called!!")
        Log.d(TAG, "## userText = $userText")
        super.onCleared()
    }
}

class CustomViewModelFactory(val userText: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomViewModel::class.java)) {
            return CustomViewModel(userText) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}