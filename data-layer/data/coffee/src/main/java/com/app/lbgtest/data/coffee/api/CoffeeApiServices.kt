package com.app.lbgtest.data.coffee.api

import com.app.lbgtest.data.coffee.model.CoffeeResponse
import com.app.lbgtest.data.coffee.utils.Constants.COFFEES_ENDPOINT
import retrofit2.http.GET

interface CoffeeApiServices {
    @GET(COFFEES_ENDPOINT)
    suspend fun getCoffeeServices(): List<CoffeeResponse>
}