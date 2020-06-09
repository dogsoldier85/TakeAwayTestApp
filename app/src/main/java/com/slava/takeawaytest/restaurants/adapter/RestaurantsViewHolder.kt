package com.slava.takeawaytest.restaurants.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.slava.takeawaytest.restaurants.entities.RestaurantsDataModel
import com.slava.takeawaytest.R

class RestaurantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.title)
    private val openStatus = itemView.findViewById<TextView>(R.id.open_status)
    private val minOrder = itemView.findViewById<TextView>(R.id.min_order)
    private val image = itemView.findViewById<ImageView>(R.id.image)

    fun bind(restaurantsDataModel: RestaurantsDataModel) {
        title.text = restaurantsDataModel.name
        openStatus.text = if (restaurantsDataModel.openStatus) {
            openStatus.context.getString(R.string.restaurants_current_status_opened)
        } else {
            openStatus.context.getString(R.string.restaurants_current_status_closed)
        }
        minOrder.text = restaurantsDataModel.minimumOrder.toString()

        Glide.with(image.context).load(restaurantsDataModel.coverImageUrl)
            .transition(DrawableTransitionOptions.withCrossFade()).into(image)
    }
}