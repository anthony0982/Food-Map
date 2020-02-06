package com.anthony.foodmap.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anthony.foodmap.model.Icon
import com.anthony.foodmap.model.Venue
import com.squareup.picasso.Picasso

@BindingAdapter("app:icon")
fun setImage(imageView: ImageView?, icon: Icon?) {
    icon?.let {
        var url = icon.prefix + "64" + icon.suffix
        Picasso.get().load(url).into(imageView)
    }
}

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Venue>) {
    (listView.adapter as VenuesAdapter).submitList(items)
}