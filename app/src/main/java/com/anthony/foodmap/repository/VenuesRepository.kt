package com.anthony.foodmap.repository

import com.anthony.foodmap.repository.api.ApiService
import javax.inject.Inject

/**
 * Interface to the data layer.
 */
class VenuesRepository @Inject constructor(var apiService: ApiService)
