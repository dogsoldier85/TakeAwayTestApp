package com.slava.takeawaytest.network.entities

import com.google.gson.annotations.SerializedName

class RestaurantServerModel(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String?,
    @SerializedName("open") val open: Boolean?,
    @SerializedName("minimumOrder") val minimumOrder: Int?,
    @SerializedName("coverImageUrl") val coverImageUrl: String?
)