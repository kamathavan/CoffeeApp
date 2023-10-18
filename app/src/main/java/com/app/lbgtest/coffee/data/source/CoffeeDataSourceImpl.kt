package com.app.lbgtest.coffee.data.source

import com.app.lbgtest.coffee.data.api.CoffeeApiService
import com.app.lbgtest.coffee.data.model.Coffee

class CoffeeDataSourceImpl(private val coffeeApiService: CoffeeApiService) : CoffeeDataSource {
    override suspend fun getCoffeeData(): List<Coffee> {
        return coffeeApiService.getCoffeeService()
    }
}