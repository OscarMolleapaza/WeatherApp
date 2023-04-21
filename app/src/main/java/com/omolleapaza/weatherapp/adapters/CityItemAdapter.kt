package com.omolleapaza.weatherapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.omolleapaza.weatherapp.databinding.ItemCityBinding
import com.omolleapaza.weatherapp.model.LocationUI

class CityItemAdapter(
    private val onItemClick: (LocationUI) -> Unit,
) : ListAdapter<LocationUI, CityItemAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = getItem(position)
        holder.bind(city)
    }

    inner class ViewHolder(
        private val binding: ItemCityBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: LocationUI) = with(binding) {
            this.city = city
            root.setOnClickListener { onItemClick(city) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<LocationUI>() {
            override fun areItemsTheSame(oldItem: LocationUI, newItem: LocationUI): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: LocationUI, newItem: LocationUI): Boolean =
                oldItem == newItem
        }
    }
}
