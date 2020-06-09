package com.slava.takeawaytest.restaurants.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.slava.takeawaytest.R
import com.slava.takeawaytest.restaurants.decoration.ItemVerticalMarginsDecoration
import com.slava.takeawaytest.restaurants.adapter.RestaurantsAdapter
import com.slava.takeawaytest.restaurants.viewmodel.MainRestaurantsScreenViewModel
import org.koin.android.ext.android.inject


class MainRestaurantsScreenFragment : Fragment() {

    private var newsAdapter = RestaurantsAdapter()
    private lateinit var errorMessage: TextView
    private val viewModel: MainRestaurantsScreenViewModel by inject()

    companion object {
        fun newInstance() =
            MainRestaurantsScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_restaurants_screen_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchRestaurants()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNewsList(view)
        errorMessage = view.findViewById(R.id.error_label)
        initViewModel()
    }

    private fun initNewsList(view: View) {
        val newsList = view.findViewById<RecyclerView>(R.id.news_list)
        newsList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        (newsList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        newsList.addItemDecoration(ItemVerticalMarginsDecoration())
        newsList.adapter = newsAdapter
        newsList.overScrollMode = View.OVER_SCROLL_NEVER
    }

    private fun initViewModel() {
        viewModel.newsLiveData()
            .observe(viewLifecycleOwner, Observer { items ->
                newsAdapter.loadItems(items)
                errorMessage.text = ""
            })
        viewModel.errorHandlingLiveData()
            .observe(viewLifecycleOwner, Observer {
                errorMessage.text = it
                errorMessage.visibility = View.VISIBLE
            })
    }
}
