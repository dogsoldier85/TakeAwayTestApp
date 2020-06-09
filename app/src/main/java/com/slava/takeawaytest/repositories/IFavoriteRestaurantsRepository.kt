package com.slava.takeawaytest.repositories

import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.persistence.FavoriteRestaurantsDBEntity

interface IFavoriteRestaurantsRepository {
    suspend fun getFavoriteRestaurants(): Result<List<FavoriteRestaurantsDBEntity>>
}