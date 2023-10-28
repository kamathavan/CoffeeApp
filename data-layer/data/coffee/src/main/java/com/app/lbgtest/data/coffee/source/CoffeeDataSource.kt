package com.app.lbgtest.data.coffee.source

import com.app.lbgtest.coffeedomain.model.Coffee
import com.app.lbgtest.data.coffee.model.CoffeeResponse


interface CoffeeDataSource {
    suspend fun getCoffeeData(): List<CoffeeResponse>
}