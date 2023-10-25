package com.app.lbgtest.coffee.presentations.coffeelist

import com.app.lbgtest.coffee.TestDispatchers
import org.junit.Before
import org.junit.Test

class CoffeeListViewModelTest {

    private lateinit var testDispatchers: TestDispatchers


    @Before
    fun setUp() {
        testDispatchers = TestDispatchers()
    }

    @Test
    fun createInitialState() {
    }
}