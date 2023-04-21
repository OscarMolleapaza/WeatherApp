package com.omolleapaza.weatherapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load

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