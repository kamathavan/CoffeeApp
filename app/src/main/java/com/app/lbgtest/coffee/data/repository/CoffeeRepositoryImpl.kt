package com.app.lbgtest.coffee.data.repository

import com.app.lbgtest.coffee.data.RequestState
import com.app.lbgtest.coffee.data.model.Coffee
import com.app.lbgtest.coffee.data.source.CoffeeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(private val coffeeDataSource: CoffeeDataSource) {
    fun getCoffees(): Flow<RequestState<List<Coffee>>> = flow {
        try {
            emit(RequestState.Loading(loading = true))
            val coffees = coffeeDataSource.getCoffeeData()
            emit(RequestState.SuccessState(data = coffees))
        } catch (e: Exception) {
            emit(
                RequestState.FailureState(
                    data = e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }
    }.flowOn(Dispatchers.IO)
}