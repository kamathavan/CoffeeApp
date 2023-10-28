package com.app.lbgtest.data.coffee.mapper

import com.app.lbgtest.coffeedomain.model.Coffee
import com.app.lbgtest.data.coffee.model.CoffeeResponse
import javax.inject.Inject

class CoffeeDataMapper @Inject constructor() {

    fun transformCoffeeData(coffeeResponse: List<CoffeeResponse>): List<Coffee> {
        return coffeeResponse.map { data ->
            Coffee(
                title = data.title,
                description = data.description,
                image = data.image,
                ingredients = data.ingredients,
                id = data.id
            )
        }
    }
}