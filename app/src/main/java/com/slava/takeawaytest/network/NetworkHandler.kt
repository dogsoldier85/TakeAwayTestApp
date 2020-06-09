package com.slava.takeawaytest.network

import com.slava.takeawaytest.BuildConfig
import com.slava.takeawaytest.R
import com.slava.takeawaytest.entities.Result
import com.slava.takeawaytest.extentions.appContext
import com.slava.takeawaytest.network.entities.RestaurantServerModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.IOException
import java.util.concurrent.TimeUnit

class NetworkHandler : INetworkHandler {
    private var retrofitService: RestaurantsApiServices

    init {
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)

        val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
        retrofitService = retrofitBuilder.build().create(RestaurantsApiServices::class.java)
    }

    override fun getRestaurants(): Result<List<RestaurantServerModel>> {
        Timber.d("Fetching restaurants from remote API")
        val response = retrofitService.getRestaurants().execute()
        return if (response.isSuccessful) {
            Timber.d("Fetching restaurants from remote API - Succeeded ${response.errorBody()}")
            Result(data = response.body())
        } else {
            Timber.d("Fetching restaurants from remote API - Failed ${response.errorBody()}")
            Result(exception = IOException(appContext.getString(R.string.general_error)))
        }
    }
}