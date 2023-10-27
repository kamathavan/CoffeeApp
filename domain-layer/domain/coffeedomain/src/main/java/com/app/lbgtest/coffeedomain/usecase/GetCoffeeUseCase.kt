package com.app.lbgtest.coffeedomain.usecase

import com.app.lbgtest.data.coffee.repository.CoffeeRepository
import javax.inject.Inject

class GetCoffeeUseCase @Inject constructor(
    private val coffeeRepository: CoffeeRepository
)  {

}