package com.example.quadexample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity2 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun onClick(view: View) {
        val intent = Intent(view.context, MainActivity::class.java)
        startActivity(intent)
    }
}