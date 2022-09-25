package com.marufalam.weatherapps

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.marufalam.weatherapps.networks.getFormattedDate
import com.marufalam.weatherapps.networks.icon_prefix
import com.marufalam.weatherapps.networks.icon_suffix

@BindingAdapter("app:setDateTime")
fun setDateTime(tv:TextView, dt:Long){
    tv.text= getFormattedDate(dt,"EEE h:mm a")

}
@BindingAdapter("app:setIcon")
fun setIcon(img:ImageView,icon:String?){
    val iconUrl = "$icon_prefix$icon$icon_suffix"
    Glide.with(img.context)
        .load(iconUrl).into(img)


}
