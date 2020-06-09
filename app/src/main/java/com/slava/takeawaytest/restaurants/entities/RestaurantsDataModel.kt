package com.slava.takeawaytest.restaurants.entities

import com.slava.takeawaytest.persistence.RestaurantsDBEntity

data class RestaurantsDataModel(
    val id: Long,
    val name: String,
    val openStatus: Boolean,
    val coverImageUrl: String,
    val minimumOrder: Int,
    var isFavorite: Boolean = false
) {
    companion object {
        fun create(restaurantsDBEntity: RestaurantsDBEntity): RestaurantsDataModel {
            return RestaurantsDataModel(
                restaurantsDBEntity.id,
                restaurantsDBEntity.name,
                restaurantsDBEntity.openStatus,
                restaurantsDBEntity.coverImageUrl,
                restaurantsDBEntity.minimumOrder
            )
        }
    }
}