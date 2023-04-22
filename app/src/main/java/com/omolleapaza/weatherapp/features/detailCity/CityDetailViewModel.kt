package com.omolleapaza.weatherapp.features.detailCity

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.WeatherModel
import com.omolleapaza.domain.usecase.ProdGetWeatherUseCase
import com.omolleapaza.weatherapp.features.detailCity.state.CityDetailState
import com.omolleapaza.weatherapp.mapper.LocationUIMapper
import com.omolleapaza.weatherapp.model.LocationUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CityDetailViewModel @Inject constructor(
    private val locationUIMapper: LocationUIMapper,
    prodGetWeatherUseCase: ProdGetWeatherUseCase,
    savedStateHandle: SavedStateHandle

) : ViewModel() {

    private val cityItem: LocationUI = savedStateHandle["location"]!!
    private val _viewState = MutableStateFlow(CityDetailState())
    val viewState get() = _viewState.asStateFlow()

    init {
        Log.i("DataCity", cityItem.toString())
        prodGetWeatherUseCase.invoke(cityItem.latitude, cityItem.longitude)
            .onStart {
                _viewState.update {
                    it.copy(isLoading = true)
                }
            }
            .onEach(::handleGetWeatherUseCase)
            .launchIn(viewModelScope)
    }

    private fun handleGetWeatherUseCase(result: Result<WeatherModel>) {
        when (result) {
            is Result.Error -> {
                result.failure?.error?.printStackTrace()
                _viewState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = result.failure?.message
                    )
                }
            }
            is Result.Success -> {
                _viewState.update {
                    it.copy(
                        isLoading = false,
                        currentCity = locationUIMapper.mapWeatherDomainToUI(result.data)
                    )
                }
            }
        }
    }
}
