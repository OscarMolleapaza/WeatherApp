package com.omolleapaza.weatherapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class LocationUI(

    val locationName: String,
    val country: String,
    val city: String,
    val urlImg: String,
    val urlFlag: String,
    val rating: String,
    val latitude: Double,
    val longitude: Double,
    val desc: String,
    val id: Int

):Parcelable


