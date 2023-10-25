package com.app.lbgtest.coffee.data.repository

import com.app.lbgtest.coffee.data.RequestState
import com.app.lbgtest.coffee.data.model.Coffee
import com.app.lbgtest.coffee.data.source.CoffeeDataSource
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class FakeCoffeeDataSource : CoffeeDataSource {

    private val flow = MutableSharedFlow<RequestState<Coffee>>()
    suspend fun emit(value: RequestState<Coffee>) = flow.emit(value)

    override suspend fun getCoffeeData(): List<Coffee> {
        return listOf(
            Coffee(
                title = "some_value",
                description = "some_value",
                ingredients = listOf("some_value", "some_value"),
                image = "some_value",
                id = "some_value"
            )
        )
    }
}