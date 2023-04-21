package com.omolleapaza.weatherapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.omolleapaza.weatherapp.adapters.CityItemAdapter
import com.omolleapaza.weatherapp.model.LocationUI

const val CROSS_FADE_DURATION = 1000

@BindingAdapter("app:url")
fun setImageUrl(view: ImageView, url: String?) {
    url?.let {
        view.load(it) {
            crossfade(true)
            crossfade(CROSS_FADE_DURATION)
        }
    }
}

@BindingAdapter("app:submitList")
fun setCityList(rv: RecyclerView, items: List<LocationUI>?) {
    items?.let {
        (rv.adapter as? CityItemAdapter)?.submitList(it)
    }
}