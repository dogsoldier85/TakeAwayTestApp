package com.slava.takeawaytest.repositories

import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.persistence.FavoriteRestaurantsDBEntity
import com.slava.takeawaytest.persistence.RestaurantsDao

class FavoriteRestaurantsRepository(private val restaurantsDao: RestaurantsDao) :
    IFavoriteRestaurantsRepository {

    override suspend fun getFavoriteRestaurants(): Result<List<FavoriteRestaurantsDBEntity>> =
        Result(restaurantsDao.loadAllFavoriteRestaurants())

}