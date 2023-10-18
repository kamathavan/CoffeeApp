package com.app.lbgtest.coffee.data.api

import com.app.lbgtest.coffee.data.model.Coffee
import com.app.lbgtest.coffee.utils.Constants.HOT_COFFEES_ENDPOINT
import retrofit2.http.GET

interface CoffeeService {

    @GET(HOT_COFFEES_ENDPOINT)
    suspend fun getHotCoffees(): List<Coffee>

}