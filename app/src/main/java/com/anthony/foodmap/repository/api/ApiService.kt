package com.anthony.foodmap.repository.api

import com.anthony.foodmap.model.VenueResultsResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun search(@Query("sw") sw: String?,
               @Query("ne") ne: String?,
               @Query("limit") limit: Int): Single<Response<VenueResultsResponse?>?>?

}