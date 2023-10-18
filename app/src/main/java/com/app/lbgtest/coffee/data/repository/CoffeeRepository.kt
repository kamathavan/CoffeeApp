package com.app.lbgtest.coffee.data.repository

import com.app.lbgtest.coffee.data.model.Coffee

interface CoffeeRepository {
    suspend fun getCoffee(): List<Coffee>
}
