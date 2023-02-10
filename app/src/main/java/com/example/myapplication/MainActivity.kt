package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  fm: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            button.setOnClickListener(this@MainActivity)
            button2.setOnClickListener(this@MainActivity)
        }
        fm = supportFragmentManager
    }

    fun loadFragment(f: Fragment) {
        val ft: FragmentTransaction = fm.beginTransaction()
        ft.replace(R.id.fragmentContainerView, f)
        ft.commit()
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            if(p0.id == R.id.button) loadFragment(FirstFragment()) else loadFragment(SecondFragment())
        }
    }

}


