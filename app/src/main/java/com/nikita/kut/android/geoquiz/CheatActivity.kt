package com.nikita.kut.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nikita.kut.android.geoquiz.databinding.ActivityCheatBinding
import com.nikita.kut.android.geoquiz.databinding.ActivityMainBinding

class CheatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "2 act onCreate")
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "2 act onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "2 act onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "2 act onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "2 act onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "2 act onDestroy")
    }
}