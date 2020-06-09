package com.slava.takeawaytest.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantsDao {

    @Query("SELECT * FROM Restaurants WHERE Restaurants.id = :id")
    fun getRestaurantById(id: Int): RestaurantsDBEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRestaurantItem(restaurantsDBItem: RestaurantsDBEntity)

    @Query("SELECT * FROM Restaurants")
    fun loadAllRestaurants(): List<RestaurantsDBEntity>

    @Query("DELETE FROM Restaurants")
    fun deleteAllRestaurants()

    @Query("SELECT * FROM FavoriteRestaurants")
    fun loadAllFavoriteRestaurants(): List<FavoriteRestaurantsDBEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavoriteRestaurantsItem(favoriteRestaurantsDBEntity: FavoriteRestaurantsDBEntity)
}

