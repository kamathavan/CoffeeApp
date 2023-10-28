package com.app.lbgtest.data.coffee.source


import com.app.lbgtest.data.coffee.api.CoffeeApiServices
import com.app.lbgtest.data.coffee.model.CoffeeResponse
import javax.inject.Inject

class CoffeeDataSourceImpl @Inject constructor(
    private val coffeeApiService: CoffeeApiServices
) : CoffeeDataSource {
    override suspend fun getCoffeeData(): List<CoffeeResponse> = coffeeApiService.getCoffeeServices()
}