package com.marufalam.weatherapps

import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.*

import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.marufalam.weatherapps.adapter.ForecastAdapter
import com.marufalam.weatherapps.databinding.FragmentWeatherBinding

import com.marufalam.weatherapps.viewmodels.LocationViewModel

class WeatherFragment : Fragment() {
    private val TAG = "WeatherFragment"
    val locationViewModel: LocationViewModel by activityViewModels()
    private lateinit var binding: FragmentWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.weather_menu,menu)
        val searchView = menu.findItem(R.id.item_search).actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.queryHint = "Search City"
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    convertCityToLatLong(query)
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
               return true;
            }

        })

    }

    private fun convertCityToLatLong(query: String?) {
        val geocoder = Geocoder(requireActivity())
        val addressList = geocoder.getFromLocationName(query,1)
        if (addressList.isNotEmpty()){
            val lat = addressList[0].latitude
            val lng = addressList[0].longitude
            val location = Location("").apply {
                latitude = lat
                longitude = lng
            }
            locationViewModel.setNewLocations(location)
        }else{
            Toast.makeText(requireActivity(), "Invalid City Name", Toast.LENGTH_SHORT).show()
        }


    }


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
            Log.e(TAG, "${it.latitude} ${it.longitude}")
            locationViewModel.fetchData()
        }
        locationViewModel.currentModelLD.observe(viewLifecycleOwner) {
            Log.e(TAG, "WeatherFragment: ,${it.main.temp}")
            binding.current =it


        }
        locationViewModel.forecastModelLD.observe(viewLifecycleOwner) {
            adapter.submitList(it.list)
        }
        return binding.root

    }


}