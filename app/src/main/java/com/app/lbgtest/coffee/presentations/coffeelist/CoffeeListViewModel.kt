package com.app.lbgtest.coffee.presentations.coffeelist

import androidx.lifecycle.viewModelScope
import com.app.lbgtest.coffee.presentations.base.BaseViewModel
import com.app.lbgtest.coffeedomain.model.RequestState
import com.app.lbgtest.coffeedomain.usecase.GetCoffeeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoffeeListViewModel @Inject constructor(
    private val getCoffeeUseCase: GetCoffeeUseCase
) : BaseViewModel<CoffeeListUiState>() {
    override fun createInitialState(): CoffeeListUiState {
        return CoffeeListUiState(coffees = emptyList())
    }

    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        getCoffeeUseCase.invoke().onEach { requestState ->
            when (requestState) {
                is RequestState.Loading -> {
                    setState(CoffeeListUiState(isLoading = true))
                }

                is RequestState.SuccessState -> {
                    setState(CoffeeListUiState(coffees = requestState.data))
                }

                is RequestState.FailureState -> {
                    setState(
                        CoffeeListUiState(
                            error = requestState.data ?: "An unexpected error occurred"
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
