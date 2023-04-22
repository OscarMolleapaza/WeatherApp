package com.omolleapaza.weatherapp.features.detailCity.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState

@Composable
fun MyGoogleMaps(lat: Double, lon: Double){
    val marker = LatLng(lat,lon)
    GoogleMap(modifier = Modifier.fillMaxSize()){
        Marker(state = MarkerState(position = marker))
    }
}