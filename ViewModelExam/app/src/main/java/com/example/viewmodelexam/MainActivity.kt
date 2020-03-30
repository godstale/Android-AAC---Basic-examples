package com.example.viewmodelexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var customViewModel: CustomViewModel
    lateinit var viewModelFactory: CustomViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create view model
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // create custom view model
        viewModelFactory = CustomViewModelFactory("view model 2")
        customViewModel = ViewModelProvider(this, viewModelFactory).get(CustomViewModel::class.java)

        // update UI
        text_desc1.text = viewModel.userText
        text_desc2.text = customViewModel.userText
    }
}
