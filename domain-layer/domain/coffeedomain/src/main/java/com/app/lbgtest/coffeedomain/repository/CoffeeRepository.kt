package com.app.lbgtest.coffeedomain.repository

import com.app.lbgtest.coffeedomain.model.Coffee
import com.app.lbgtest.coffeedomain.model.RequestState
import kotlinx.coroutines.flow.Flow


interface CoffeeRepository {
    fun getCoffees(): Flow<RequestState<List<Coffee>>>
}