package com.omolleapaza.weatherapp.features.detailCity.screen

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.omolleapaza.weatherapp.features.detailCity.CityDetailViewModel
import com.omolleapaza.weatherapp.features.detailCity.components.MyGoogleMaps
import com.omolleapaza.weatherapp.features.detailCity.state.CityDetailState

@Composable
fun CityDetailScreen(
    viewModel: CityDetailViewModel,
    onBackButtonAction: () -> Unit = {},
) {
    val viewState: CityDetailState by viewModel.viewState.collectAsState()
    Log.i("viewState", viewState.toString())

    MyGoogleMaps(
        lat = viewState.currentCity?.coordinates?.latitude ?: 0.0,
        lon = viewState.currentCity?.coordinates?.longitude ?: 0.0
    )

}