package com.slava.takeawaytest.di

import com.slava.takeawaytest.mock.MockNetworkHandler
import com.slava.takeawaytest.extentions.appContext
import com.slava.takeawaytest.network.INetworkHandler
import com.slava.takeawaytest.network.NetworkHandler
import com.slava.takeawaytest.restaurants.viewmodel.MainRestaurantsScreenViewModel
import com.slava.takeawaytest.persistence.RestaurantsDatabase
import com.slava.takeawaytest.repositories.FavoriteRestaurantsRepository
import com.slava.takeawaytest.repositories.IFavoriteRestaurantsRepository
import com.slava.takeawaytest.repositories.IRestaurantsRepository
import com.slava.takeawaytest.repositories.RestaurantsRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {
    single<INetworkHandler> { NetworkHandler() }
    //single<INetworkHandler> { MockNetworkHandler() }
    single { RestaurantsDatabase.getInstance(appContext).restaurantsDao() }
    single<IRestaurantsRepository> { RestaurantsRepository(get(), get()) }
    single<IFavoriteRestaurantsRepository> { FavoriteRestaurantsRepository(get()) }
    viewModel { MainRestaurantsScreenViewModel(get(), get()) }
}
