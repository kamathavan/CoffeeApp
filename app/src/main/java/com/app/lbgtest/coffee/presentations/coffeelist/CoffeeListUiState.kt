package com.app.lbgtest.coffee.presentations.coffeelist

import com.app.lbgtest.coffee.presentations.base.IViewState
import com.app.lbgtest.coffeedomain.model.Coffee

data class CoffeeListUiState(
    val isLoading: Boolean = false,
    val coffees: List<Coffee>? = emptyList(),
    val error: String = ""
) : IViewState