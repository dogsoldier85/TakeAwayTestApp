package com.slava.takeawaytest.restaurants.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.slava.takeawaytest.R
import com.slava.takeawaytest.extentions.appContext
import com.slava.takeawaytest.repositories.IFavoriteRestaurantsRepository
import com.slava.takeawaytest.repositories.IRestaurantsRepository
import com.slava.takeawaytest.restaurants.entities.RestaurantsDataModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainRestaurantsScreenViewModel(
    private val restaurantsRepository: IRestaurantsRepository,
    private val favoriteRestaurantsRepository: IFavoriteRestaurantsRepository
) : ViewModel() {

    private val restaurantsLiveData: MutableLiveData<List<RestaurantsDataModel>> = MutableLiveData()
    private val errorHandling: MutableLiveData<String> = MutableLiveData()

    fun fetchRestaurants() {
        CoroutineScope(IO).launch {
            val restaurants = restaurantsRepository.getRestaurants()
            val favoriteRestaurants = favoriteRestaurantsRepository.getFavoriteRestaurants()
            val favoriteRestaurantsIdsHashSet = favoriteRestaurants.data?.toHashSet() ?: HashSet()
            if (restaurants.data?.isNotEmpty() == true) {

                val uiData = ArrayList<RestaurantsDataModel>()
                restaurants.data.forEach { restaurant ->
                    val restaurantsDataModel = RestaurantsDataModel.create(restaurant)
                    if (favoriteRestaurantsIdsHashSet.find { it.id == restaurant.id } != null) {
                        restaurantsDataModel.isFavorite = true
                    }
                    uiData.add(restaurantsDataModel)
                }
                restaurantsLiveData.postValue(uiData)
            } else {
                errorHandling.postValue(appContext.getString(R.string.no_data_to_show))
            }
        }
    }

    fun newsLiveData(): LiveData<List<RestaurantsDataModel>> {
        return restaurantsLiveData
    }

    fun errorHandlingLiveData(): LiveData<String> {
        return errorHandling
    }
}
