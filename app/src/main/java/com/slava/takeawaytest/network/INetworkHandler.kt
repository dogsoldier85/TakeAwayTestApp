package com.slava.takeawaytest.network

import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.network.entities.RestaurantServerModel

interface INetworkHandler {

    fun getRestaurants(): Result<List<RestaurantServerModel>>
}