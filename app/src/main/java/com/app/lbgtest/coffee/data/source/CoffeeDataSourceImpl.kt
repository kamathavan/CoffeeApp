package com.app.lbgtest.coffee.data.source

import com.app.lbgtest.coffee.data.api.CoffeeApiService
import com.app.lbgtest.coffee.data.model.Coffee
import javax.inject.Inject

class CoffeeDataSourceImpl @Inject constructor(
    private val coffeeApiService: CoffeeApiService
) : CoffeeDataSource {
    override suspend fun getCoffeeData(): List<Coffee> = coffeeApiService.getCoffeeService()
}