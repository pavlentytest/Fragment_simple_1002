package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener{ loadFragment(FirstFragment())}
        binding.button2.setOnClickListener{ loadFragment(SecondFragment())}
        fm = supportFragmentManager
    }

    fun loadFragment(f: Fragment) {
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragmentContainerView, f)
        ft.commit()
    }

}