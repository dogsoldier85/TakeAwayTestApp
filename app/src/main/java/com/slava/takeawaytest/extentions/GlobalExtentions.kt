package com.slava.takeawaytest.extentions

import android.content.Context
import com.slava.takeawaytest.RestaurantsApplication

val appContext: Context
    get() = RestaurantsApplication.instance.applicationContext
