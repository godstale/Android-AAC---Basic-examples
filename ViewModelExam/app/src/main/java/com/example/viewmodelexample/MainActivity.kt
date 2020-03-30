package com.example.viewmodelexample

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

        // create basic view model
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // create custom view model
        viewModelFactory = CustomViewModelFactory(0)
        customViewModel = ViewModelProvider(this, viewModelFactory).get(CustomViewModel::class.java)

        // init UI
        text_desc1.text = viewModel.getCountText()
        text_desc2.text = customViewModel.getCountText()

        // update UI
        button_class.setOnClickListener {
            text_desc1.text = viewModel.clickButton()
            text_desc2.text = customViewModel.clickButton()
        }
    }
}
