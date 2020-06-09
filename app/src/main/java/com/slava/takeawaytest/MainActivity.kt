package com.slava.takeawaytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.slava.takeawaytest.restaurants.fragments.MainRestaurantsScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainRestaurantsScreenFragment.newInstance(), null)
            .commit()
    }
}
