package com.marufalam.weatherapps

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.marufalam.weatherapps.adapter.ForecastAdapter
import com.marufalam.weatherapps.databinding.FragmentWeatherBinding
import com.marufalam.weatherapps.models.CurrentModel
import com.marufalam.weatherapps.viewmodels.LocationViewModel

class WeatherFragment : Fragment() {
    val locationViewModel: LocationViewModel by activityViewModels()
    private lateinit var binding: FragmentWeatherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWeatherBinding.inflate(inflater, container, false)

        val adapter = ForecastAdapter()
        val llm = LinearLayoutManager(requireActivity())
        llm.orientation = LinearLayoutManager.HORIZONTAL
        binding.forecastRV.layoutManager = llm
        binding.forecastRV.adapter = adapter

        locationViewModel.locationLiveData.observe(viewLifecycleOwner) {
            locationViewModel.fetchData()
        }
        locationViewModel.currentModelLD.observe(viewLifecycleOwner) {
            Log.e("TAG", "WeatherFragment: ,${it.main.temp}")
            println("...........")
            binding.current =it

                Toast.makeText(requireActivity(), "${it.main.temp}", Toast.LENGTH_LONG).show()
        }
        locationViewModel.forecastModelLD.observe(viewLifecycleOwner) {
            adapter.submitList(it.list)
        }
        return binding.root

    }


}