package com.leonardo.cart.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leonardo.cart.databinding.ActivityHostBinding

class HostActivity : AppCompatActivity() {

    private val binding: ActivityHostBinding by lazy {
        ActivityHostBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
