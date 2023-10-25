package com.app.lbgtest.coffee.data.repository

import app.cash.turbine.test
import com.app.lbgtest.coffee.TestDispatchers
import com.app.lbgtest.coffee.data.RequestState
import com.app.lbgtest.coffee.data.model.Coffee
import com.app.lbgtest.coffee.data.source.CoffeeDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class CoffeeRepositoryImplTest {

    @Mock
    lateinit var coffeeDataSource: CoffeeDataSource

    private lateinit var testDispatchers: TestDispatchers

    @InjectMocks
    lateinit var coffeeRepositoryImpl: CoffeeRepositoryImpl

    @Before
    fun setUp() {
        testDispatchers = TestDispatchers()
        coffeeRepositoryImpl = CoffeeRepositoryImpl(FakeCoffeeDataSource())

    }

    @Test
    fun `success state`() = runTest {
        val coffeeDataSource1 = FakeCoffeeDataSource()
        coffeeRepositoryImpl = CoffeeRepositoryImpl(FakeCoffeeDataSource())

        coffeeRepositoryImpl.getCoffees().flowOn(testDispatchers.default).test {
            coffeeDataSource1.emit(RequestState.Loading<Coffee>(loading = true))
            assertTrue(RequestState.Loading<Coffee>(loading = true) === awaitItem())
        }


    }

    @Test
    fun `Given two states, When counting states, Then return the Success total count of states`() =
        runTest {
            val emittedValue = 2

            val countValue = coffeeRepositoryImpl.getCoffees().flowOn(testDispatchers.io).count()

            assertEquals(emittedValue, countValue)
        }

    @Test
    fun `Given list of coffee, When emitting of request state, Then  return the Success state of Coffee`() =
        runTest {
            // given
            doReturn(
                listOf(
                    Coffee(
                        title = "some_value",
                        description = "some_value",
                        ingredients = listOf("some_value", "some_value"),
                        image = "some_value",
                        id = "some_value"
                    )
                )
            ).`when`(coffeeDataSource).getCoffeeData()


            // when and then

            val requestState = coffeeRepositoryImpl.getCoffees().single()


        }

    @Test
    fun `Given coffee data source throwing error, When coffee emitting  request state, Then Coffee repository of throwing failure state of response`() =
        runTest {
            // given
            doReturn(
                RuntimeException("An unexpected error occurred")
            ).`when`(coffeeDataSource).getCoffeeData()

            val coffeeRepository = CoffeeRepositoryImpl(coffeeDataSource)

            // When and Then

            coffeeRepository.getCoffees().flowOn(testDispatchers.io).test {

                cancelAndIgnoreRemainingEvents()

                assertEquals(
                    RequestState.FailureState<Coffee>(
                        data = "An unexpected error occurred"
                    ),
                    awaitItem()
                )
            }
        }
}