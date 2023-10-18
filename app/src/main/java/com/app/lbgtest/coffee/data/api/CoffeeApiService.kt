package com.app.lbgtest.coffee.data.api

import com.app.lbgtest.coffee.data.model.Coffee
import com.app.lbgtest.coffee.utils.Constants.COFFEES_ENDPOINT
import retrofit2.http.GET

interface CoffeeApiService {
    @GET(COFFEES_ENDPOINT)
    suspend fun getCoffeeService(): List<Coffee>
}