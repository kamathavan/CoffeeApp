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
    operator fun invoke(): Flow<RequestState<List<Coffee>>> = coffeeRepository.getCoffees()

}