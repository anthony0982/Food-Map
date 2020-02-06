package com.anthony.foodmap.model

data class Venue(val id:String, val name:String, val location: Location, var categories: List<Category>)