package com.omolleapaza.weatherapp.features.detailCity.screen

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.omolleapaza.weatherapp.R
import com.omolleapaza.weatherapp.features.detailCity.CityDetailViewModel
import com.omolleapaza.weatherapp.features.detailCity.components.CoilImage
import com.omolleapaza.weatherapp.features.detailCity.components.LabelWeatherText
import com.omolleapaza.weatherapp.features.detailCity.components.TitleText
import com.omolleapaza.weatherapp.features.detailCity.state.CityDetailState
import com.omolleapaza.weatherapp.features.detailCity.theme.fontFamily
import com.omolleapaza.weatherapp.model.LocationUI
import com.omolleapaza.weatherapp.model.WeatherUI

@Composable
fun CityDetailScreen(
    viewModel: CityDetailViewModel,
    onBackButtonAction: () -> Unit = {},
) {
    val viewState: CityDetailState by viewModel.viewState.collectAsState()
    Log.i("viewState", viewState.toString())

    CityDetail(
        viewState = viewState,
        onBackButtonAction = onBackButtonAction
    )

}
@Composable
private fun CityDetail(viewState: CityDetailState, onBackButtonAction: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.gray)),
    ) {
        if (viewState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
            )
        }
        AnimatedVisibility(
            visible = !viewState.isLoading,
            enter = fadeIn(animationSpec = tween(1000)),
            exit = fadeOut(animationSpec = tween(1000)),
        ) {
            CityDetailBody(
                city = viewState.currentCity,
                weather = viewState.currentWeather,
                onBackButtonAction = onBackButtonAction,
            )
        }
    }
}
@Composable
private fun CityDetailBody(
    city: LocationUI?,
    weather: WeatherUI?,
    onBackButtonAction: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .background(color = colorResource(id = R.color.gray)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HeaderDetail(
            cityTitle = city?.city.orEmpty(),
            onBackButtonAction = onBackButtonAction,
        )

        Spacer(modifier = Modifier.height(20.dp))

        MyGoogleMaps(lat = city?.latitude?:0.0, lon = city?.longitude?:0.0 )

        Spacer(modifier = Modifier.height(20.dp))


        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)) {

            CoilImage(urlImg = city?.urlFlag.orEmpty())
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = city?.city?:"", fontFamily = fontFamily, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = city?.desc?:"", fontFamily = fontFamily, color = Color.White, fontWeight = FontWeight.Normal)
            LabelWeatherText(label = String.format("%.3f", weather!!.main.temp_max - 273.15), type = "Temperatura Maxima" )
            LabelWeatherText(label = String.format("%.3f", weather.main.temp - 273.15), type = "Temperatura Actual" )
            LabelWeatherText(label = String.format("%.3f", weather.main.temp_min - 273.15), type = "Temperatura Minima" )

        }

    }
}

@Composable
fun MyGoogleMaps(lat: Double, lon: Double){
    val marker = LatLng(lat,lon)
    GoogleMap(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)){
        Marker(state = MarkerState(position = marker))
    }
}
@Composable
private fun HeaderDetail(
    cityTitle: String?,
    onBackButtonAction: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(10.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.7f)
                .align(Alignment.Center),
            contentAlignment = Alignment.Center,
        ) {
            TitleText(text = cityTitle.orEmpty())
        }
        IconButton(onClick = { onBackButtonAction() }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.img_des_back_arrow),
                tint = Color.White,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        CityDetailBody(
           city = LocationUI(
               locationName = "Arequipa",
               country = "PE",
               city = "Arequipa",
               urlImg = "https://i.pinimg.com/550x/29/2c/c1/292cc19fa1f63a7842a6f3ac24d2ee1c.jpg",
               urlFlag = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Flag_of_Peru_%28state%29.svg/800px-Flag_of_Peru_%28state%29.svg.png",
               rating = "4.5",
               latitude = -16.4040516,
               longitude = -71.556521,
               desc = "Arequipa es la capital de la época colonial de la región de Arequipa en Perú. La rodean 3 volcanes y cuenta con edificios barrocos construidos de sillar, una piedra volcánica blanca.",
               id = 2
           ),
            weather = null
        )
    }
}