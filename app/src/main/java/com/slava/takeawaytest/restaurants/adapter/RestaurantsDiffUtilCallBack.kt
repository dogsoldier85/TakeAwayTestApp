package com.slava.takeawaytest.restaurants.adapter

import androidx.recyclerview.widget.DiffUtil
import com.slava.takeawaytest.restaurants.entities.RestaurantsDataModel

class RestaurantsDiffUtilCallBack(
    private val oldList: List<RestaurantsDataModel>,
    private val newList: List<RestaurantsDataModel>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldList[oldItemPosition]
        val new = newList[newItemPosition]

        return old == new
    }
}