package com.app.lbgtest.data.coffee.model

data class CoffeeResponse(
    val title: String?,
    val description: String,
    val ingredients: List<String>,
    val image: String,
    val id: String,
)