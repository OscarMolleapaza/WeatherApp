package com.omolleapaza.weatherapp.features.listLocations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omolleapaza.core.Result
import com.omolleapaza.domain.entities.LocationModel
import com.omolleapaza.domain.usecase.ProdGetLocationsUseCase
import com.omolleapaza.domain.usecase.ProdInsertLocationUseCase
import com.omolleapaza.weatherapp.features.listLocations.state.CityListState
import com.omolleapaza.weatherapp.mapper.LocationUIMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class CityListViewModel @Inject constructor(
    private val locationUIMapper: LocationUIMapper,
    prodInsertLocationUseCase: ProdInsertLocationUseCase,
    prodGetLocationsUseCase: ProdGetLocationsUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow(CityListState())
    val viewState get() = _viewState.asStateFlow()

    init {
        prodInsertLocationUseCase.invoke(
            locationModel = LocationModel(
                locationName = "Londres",
                country = "UK",
                city = "Londres",
                urlImg = "https://images.unsplash.com/photo-1529655683826-aba9b3e77383?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8bG9uZG9ufGVufDB8fDB8fA%3D%3D&w=1000&q=80",
                urlFlag = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Flag_of_Great_Britain_%281707–1800%29.svg/220px-Flag_of_Great_Britain_%281707–1800%29.svg.png",
                rating = "4.9",
                latitude = 51.5285582,
                longitude = -0.2416794,
                desc = "Londres, la capital de Inglaterra y del Reino Unido, es una ciudad del siglo XXI con una historia que se remonta a la época romana. ",
                id = 0
            )
        )
        prodInsertLocationUseCase.invoke(
            locationModel = LocationModel(
                locationName = "Puno",
                country = "PE",
                city = "Arequipa",
                urlImg = "https://c0.wallpaperflare.com/preview/722/187/818/puno-lake-quechua-titicaca.jpg",
                urlFlag = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Flag_of_Peru_%28state%29.svg/800px-Flag_of_Peru_%28state%29.svg.png",
                rating = "4.5",
                latitude = -16.4040516,
                longitude = -71.556521,
                desc = "Puno es una ciudad del sur de Perú ubicada junto al lago Titicaca, uno de los lagos más grandes de Sudamérica y el cuerpo de agua navegable más alto del mundo.",
                id = 1
            )
        )
        prodInsertLocationUseCase.invoke(
            locationModel = LocationModel(
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
            )
        )
        prodGetLocationsUseCase()
            .onStart {
                _viewState.update { it.copy(isLoading = true) }
            }
            .onEach(::handleGetLocationListUseCase)
            .launchIn(viewModelScope)
    }
    private fun handleGetLocationListUseCase(result: Result<List<LocationModel>>){
        when(result){
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
                val locationList = result.data.map(locationUIMapper::maplocationDomainToUI)
                _viewState.update {
                    it.copy(isLoading = false, locationList = locationList)
                }
            }
        }
    }


}
