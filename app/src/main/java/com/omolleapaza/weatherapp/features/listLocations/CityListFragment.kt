package com.omolleapaza.weatherapp.features.listLocations

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.omolleapaza.weatherapp.adapters.CityItemAdapter
import com.omolleapaza.weatherapp.databinding.FragmentCityListBinding
import com.omolleapaza.weatherapp.model.LocationUI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityListFragment : Fragment() {

    private lateinit var binding: FragmentCityListBinding
    private val viewModel: CityListViewModel by viewModels()

    private val cityItemAdapter: CityItemAdapter by lazy { CityItemAdapter(::onItemClick) }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentCityListBinding.inflate(inflater, container, false)
        binding.cityListViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvCityList.adapter = cityItemAdapter
    }

    private fun onItemClick(movie: LocationUI) {
        findNavController().navigate(CityListFragmentDirections.actionCityListFragmentToCityDetailFragment())
    }


}
