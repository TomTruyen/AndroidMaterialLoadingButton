package com.tomtruyen.loadingbutton.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tomtruyen.android.material.loadingbutton.LoadingButton
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val button = findViewById<LoadingButton>(R.id.button)
        button.onClick {
            it.startLoading()
        }
    }
}