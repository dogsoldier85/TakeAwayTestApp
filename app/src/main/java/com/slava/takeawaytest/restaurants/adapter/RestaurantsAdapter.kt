package com.slava.takeawaytest.restaurants.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.slava.takeawaytest.restaurants.entities.RestaurantsDataModel
import com.slava.takeawaytest.R

class RestaurantsAdapter : RecyclerView.Adapter<RestaurantsViewHolder>() {

    private val data = ArrayList<RestaurantsDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.restaurant_item_view, parent, false)
        return RestaurantsViewHolder(itemView)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun loadItems(newData: List<RestaurantsDataModel>) {
        val diffCallback =
            RestaurantsDiffUtilCallBack(data, newData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        data.clear()
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }
}