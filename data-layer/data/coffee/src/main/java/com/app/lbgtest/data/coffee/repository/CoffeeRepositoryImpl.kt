package com.app.lbgtest.data.coffee.repository

import com.app.lbgtest.data.coffee.model.Coffee
import com.app.lbgtest.data.coffee.source.CoffeeDataSource
import com.app.lbgtest.data.coffee.source.CoffeeDataSourceImpl
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(private val coffeeDataSource: CoffeeDataSource) :
    CoffeeRepository {
    override suspend fun getCoffees(): List<Coffee> = coffeeDataSource.getCoffeeData()
}