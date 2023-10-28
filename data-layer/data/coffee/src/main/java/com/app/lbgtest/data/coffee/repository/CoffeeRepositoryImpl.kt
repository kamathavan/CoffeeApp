package com.app.lbgtest.data.coffee.repository

import com.app.lbgtest.coffeedomain.model.Coffee
import com.app.lbgtest.coffeedomain.model.RequestState
import com.app.lbgtest.coffeedomain.repository.CoffeeRepository
import com.app.lbgtest.data.coffee.mapper.CoffeeDataMapper
import com.app.lbgtest.data.coffee.source.CoffeeDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class CoffeeRepositoryImpl @Inject constructor(
    private val coffeeDataSource: CoffeeDataSource,
    private val coffeeDataMapper: CoffeeDataMapper
) : CoffeeRepository {

    override fun getCoffees(): Flow<RequestState<List<Coffee>>> = flow {
        try {
            emit(RequestState.Loading<List<Coffee>>(loading = true))
            val coffees = coffeeDataSource.getCoffeeData()
            emit(
                RequestState.SuccessState<List<Coffee>>(
                    data = coffeeDataMapper.transformCoffeeData(
                        coffees
                    )
                )
            )
        } catch (e: Exception) {
            emit(
                RequestState.FailureState<List<Coffee>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }
    }.flowOn(Dispatchers.IO)

}