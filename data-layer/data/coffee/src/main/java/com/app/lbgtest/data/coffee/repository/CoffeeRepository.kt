package com.app.lbgtest.data.coffee.repository

import com.app.lbgtest.data.coffee.model.Coffee

interface CoffeeRepository {
    suspend fun getCoffees(): List<Coffee>
}