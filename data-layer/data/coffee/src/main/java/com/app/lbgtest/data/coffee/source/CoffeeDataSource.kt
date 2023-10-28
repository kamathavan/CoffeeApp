package com.app.lbgtest.data.coffee.source

import com.app.lbgtest.coffeedomain.model.Coffee


interface CoffeeDataSource {
    suspend fun getCoffeeData(): List<Coffee>
}