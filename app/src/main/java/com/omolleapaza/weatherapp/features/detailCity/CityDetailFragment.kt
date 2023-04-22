package com.omolleapaza.weatherapp.features.detailCity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.omolleapaza.weatherapp.features.detailCity.screen.CityDetailScreen
import com.omolleapaza.weatherapp.features.detailCity.theme.CityDetailTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityDetailFragment : Fragment() {

    private val viewModel: CityDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CityDetailTheme {
                    CityDetailScreen(
                        viewModel =  viewModel,
                        onBackButtonAction = { findNavController().popBackStack() }
                    )
                }
            }
        }
    }
}
