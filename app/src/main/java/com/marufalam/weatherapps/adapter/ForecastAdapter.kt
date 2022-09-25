package com.marufalam.weatherapps.adapter

import android.media.browse.MediaBrowser
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.marufalam.weatherapps.databinding.ForecastItemRowBinding
import com.marufalam.weatherapps.models.ForecastModel

class ForecastAdapter:ListAdapter<ForecastModel.ForeCastList,ForecastAdapter.ForeCastViewHolder>(ForecastDiffUtil()) {



    class ForeCastViewHolder(val binding:ForecastItemRowBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:ForecastModel.ForeCastList){
            binding.forecast =item
        }
    }

    class ForecastDiffUtil:DiffUtil.ItemCallback<ForecastModel.ForeCastList>(){
        override fun areItemsTheSame(
            oldItem: ForecastModel.ForeCastList,
            newItem: ForecastModel.ForeCastList
        ): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastModel.ForeCastList,
            newItem: ForecastModel.ForeCastList
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForeCastViewHolder {
        val binding = ForecastItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ForeCastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForeCastViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}