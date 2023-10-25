package com.app.lbgtest.coffee.presentations.coffeelist

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.app.lbgtest.coffee.presentations.base.BaseViewModel
import com.app.lbgtest.coffee.data.RequestState
import com.app.lbgtest.coffee.data.repository.CoffeeRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoffeeListViewModel @Inject constructor(
    private val coffeeRepository: CoffeeRepositoryImpl
) : BaseViewModel<CoffeeListUiState>() {
    override fun createInitialState(): CoffeeListUiState {
        return CoffeeListUiState(coffees = emptyList())
    }

    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        coffeeRepository.getCoffees().onEach { state ->
            when (state) {
                is RequestState.Loading -> {
                    setState(
                        CoffeeListUiState(
                            isLoading = true
                        )
                    )
                }

                is RequestState.SuccessState -> {
                    setState(
                        CoffeeListUiState(
                            coffees = state.data
                        )
                    )
                }

                is RequestState.FailureState -> {
                    setState(
                        CoffeeListUiState(
                            error = state.data
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
