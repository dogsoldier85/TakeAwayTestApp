package com.slava.takeawaytest.mock

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.extentions.appContext
import com.slava.takeawaytest.network.INetworkHandler
import com.slava.takeawaytest.network.entities.RestaurantServerModel
import com.slava.takeawaytest.utils.GsonUtils


class MockNetworkHandler : INetworkHandler {
    override fun getRestaurants(): Result<List<RestaurantServerModel>> {
        val jsonFileString = GsonUtils().getJsonDataFromAsset(appContext, "raw/restaurants.json")

        val gson = Gson()
        val listPersonType = object : TypeToken<List<RestaurantServerModel>>() {}.type

        var restaurants: List<RestaurantServerModel> = gson.fromJson(jsonFileString, listPersonType)

        return Result(restaurants)
    }
}