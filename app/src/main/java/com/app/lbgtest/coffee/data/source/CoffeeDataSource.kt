package com.app.lbgtest.coffee.data.source

import com.app.lbgtest.coffee.data.model.Coffee

interface CoffeeDataSource {
    suspend fun getCoffeeData(): List<Coffee>
}