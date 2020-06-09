package com.slava.takeawaytest.repositories

import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.network.INetworkHandler
import com.slava.takeawaytest.persistence.RestaurantsDBEntity
import com.slava.takeawaytest.persistence.RestaurantsDao
import timber.log.Timber

class RestaurantsRepository(
    private val networkHandler: INetworkHandler,
    private val restaurantsDao: RestaurantsDao
) :
    IRestaurantsRepository {

    override suspend fun getRestaurants(): Result<List<RestaurantsDBEntity>> {
        val savedRestaurants = restaurantsDao.loadAllRestaurants()
        if (savedRestaurants.isNotEmpty()) {
            return Result(savedRestaurants)
        } else {
            val restaurants = networkHandler.getRestaurants()
            if (restaurants.exception == null) {
                Timber.d("Clearing all DB")
                restaurantsDao.deleteAllRestaurants()
                Timber.d("Saving all restaurants from remote to DB")
                restaurants.data?.forEach { item ->
                    Timber.d("Inserting restaurants item to DB $item")
                    restaurantsDao.insertRestaurantItem(
                        RestaurantsDBEntity(
                            id = item.id,
                            name = item.name ?: "",
                            openStatus = item.open ?: false,
                            coverImageUrl = item.coverImageUrl ?: "",
                            minimumOrder = item.minimumOrder ?: 0
                        )
                    )
                }
            }
            return Result(restaurantsDao.loadAllRestaurants())
        }
    }

    override suspend fun getRestaurantsById(id: Int): Result<RestaurantsDBEntity> =
        Result(restaurantsDao.getRestaurantById(id))
}
