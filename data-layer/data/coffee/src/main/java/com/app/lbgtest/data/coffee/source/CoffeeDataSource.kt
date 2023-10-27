package com.app.lbgtest.data.coffee.source

import com.app.lbgtest.data.coffee.model.Coffee

interface CoffeeDataSource {
    suspend fun getCoffeeData(): List<Coffee>
}