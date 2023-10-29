package com.app.lbgtest.data.coffee.mapper

import com.app.lbgtest.data.coffee.model.CoffeeResponse
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CoffeeDataMapperTest {

    lateinit var coffeeMapper: CoffeeDataMapper

    @Before
    fun setUp() {
        coffeeMapper = CoffeeDataMapper()
    }

    @Test
    fun `Given list of coffee response, When transform to mapper, Then return domain model list of coffees object`() {
        // given
        val coffeeResponseList = mutableListOf<CoffeeResponse>(
            CoffeeResponse(
                title = "some_title",
                description = "some_description",
                image = "some_image",
                ingredients = listOf<String>("some_ingridient1", "some_ingridient2"),
                id = "some_id"
            )
        )
        // when
        val result = coffeeMapper.transformCoffeeData(coffeeResponse = coffeeResponseList)

        // then
        val expectedId = "some_id"
        val expectedDescription = "some_description"
        val expectedImage = "some_image"

        assertEquals(expectedId, result[0].id)
        assertEquals(expectedDescription, result[0].description)
        assertEquals(expectedImage, result[0].image)

    }
}