package com.app.lbgtest.data.coffee.api

import com.app.lbgtest.data.coffee.model.Coffee
import retrofit2.http.GET

interface CoffeeApiServices {
    @GET()
    suspend fun getCoffeeServices(): List<Coffee>
}