package com.sean.lieb.searchmodule

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sean.lieb.searchmodule.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(){
    val TAG = javaClass.simpleName
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Search Module started")

        binding = ActivitySearchBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}