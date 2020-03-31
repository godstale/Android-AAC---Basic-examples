package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create basic view model
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // observe live data
        viewModel.countText.observe(this, Observer {
            // it 는 LiveData 로 선언된 countText 가 변경되었을 때 전달되는 값(String 형)
            text_desc1.text = it
        })

        // initialize view model
        viewModel.init()

        // update UI
        button_class.setOnClickListener {
            viewModel.clickButton()
        }
    }
}
