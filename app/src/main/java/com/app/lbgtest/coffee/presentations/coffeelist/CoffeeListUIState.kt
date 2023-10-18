package com.app.lbgtest.coffee.presentations.coffeelist

import app.selcukokc.coffeeguide.presentation.base.IViewState
import com.app.lbgtest.coffee.data.model.Coffee

data class CoffeeListUIState(
    val isLoading: Boolean = false,
    val coffees: List<Coffee>? = emptyList(),
    val error: String = ""
) : IViewState