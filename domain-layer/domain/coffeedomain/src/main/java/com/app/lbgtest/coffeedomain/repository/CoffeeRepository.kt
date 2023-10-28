package com.app.lbgtest.coffeedomain.repository

import com.app.lbgtest.coffeedomain.model.Coffee


interface CoffeeRepository {
    suspend fun getCoffees(): List<Coffee>
}