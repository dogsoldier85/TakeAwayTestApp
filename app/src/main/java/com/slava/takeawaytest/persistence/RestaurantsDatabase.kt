package com.slava.takeawaytest.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RestaurantsDBEntity::class, FavoriteRestaurantsDBEntity::class], version = 1)
abstract class RestaurantsDatabase : RoomDatabase() {

    abstract fun restaurantsDao(): RestaurantsDao

    companion object {

        @Volatile
        private var INSTANCE: RestaurantsDatabase? = null

        fun getInstance(context: Context): RestaurantsDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                    context.applicationContext,
                    RestaurantsDatabase::class.java, "RestaurantsDB.db"
                )
                .build()
    }
}


