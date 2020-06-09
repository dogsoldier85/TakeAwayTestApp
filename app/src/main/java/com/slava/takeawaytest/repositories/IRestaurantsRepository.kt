package com.slava.takeawaytest.repositories

import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.persistence.RestaurantsDBEntity

interface IRestaurantsRepository {
    suspend fun getRestaurants(): Result<List<RestaurantsDBEntity>>
    suspend fun getRestaurantsById(id: Int): Result<RestaurantsDBEntity>
}