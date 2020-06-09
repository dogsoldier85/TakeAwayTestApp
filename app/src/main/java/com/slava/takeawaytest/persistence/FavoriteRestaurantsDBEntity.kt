package com.slava.takeawaytest.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FavoriteRestaurants")
data class FavoriteRestaurantsDBEntity (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Long
)