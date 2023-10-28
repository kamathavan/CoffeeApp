package com.app.lbgtest.coffeedomain.usecase

import com.app.lbgtest.coffeedomain.model.Coffee
import com.app.lbgtest.coffeedomain.model.RequestState
import com.app.lbgtest.coffeedomain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject

class GetCoffeeUseCase @Inject constructor(
    private val coffeeRepository: CoffeeRepository
) {
    operator fun invoke(): Flow<RequestState<List<Coffee>>> = flow {
        try {
            emit(RequestState.Loading<List<Coffee>>(loading = true))
            val coffees = coffeeRepository.getCoffees()
            emit(RequestState.SuccessState<List<Coffee>>(data = coffees))
        } catch (e: Exception) {
            emit(
                RequestState.FailureState<List<Coffee>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        }

    }.flowOn(Dispatchers.IO)

}