package com.slava.takeawaytest.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Restaurants")
data class RestaurantsDBEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "openStatus") val openStatus: Boolean,
    @ColumnInfo(name = "coverImageUrl") val coverImageUrl: String,
    @ColumnInfo(name = "minimumOrder") val minimumOrder: Int
)