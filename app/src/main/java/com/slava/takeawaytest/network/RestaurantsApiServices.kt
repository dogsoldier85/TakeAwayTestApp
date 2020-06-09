package com.slava.takeawaytest.network

import com.slava.takeawaytest.network.entities.RestaurantServerModel
import retrofit2.Call
import retrofit2.http.*

interface RestaurantsApiServices {

    @GET("gilgoldzweig/SampleTest/tree/master/restaurants")
    fun getRestaurants(): Call<List<RestaurantServerModel>>
}