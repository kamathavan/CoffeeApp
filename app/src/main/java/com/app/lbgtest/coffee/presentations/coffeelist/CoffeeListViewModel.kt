package com.app.lbgtest.coffee.presentations.coffeelist

import android.util.Log
import androidx.lifecycle.viewModelScope
import app.selcukokc.coffeeguide.presentation.base.BaseViewModel
import com.app.lbgtest.coffee.data.RequestState
import com.app.lbgtest.coffee.data.repository.CoffeeRepositoryImpl
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoffeeListViewModel @Inject constructor(
    private val coffeeRepository: CoffeeRepositoryImpl
) : BaseViewModel<CoffeeListUIState>() {
    override fun createInitialState(): CoffeeListUIState {
        return CoffeeListUIState(coffees = emptyList())
    }

    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        coffeeRepository.getCoffees().onEach { state ->
            when (state) {
                is RequestState.Loading -> {
                    setState(
                        CoffeeListUIState(
                            isLoading = true
                        )
                    )
                }

                is RequestState.SuccessState -> {
                    setState(
                        CoffeeListUIState(
                            coffees = state.data
                        )
                    )
                    Log.i("TAG", "getHotCoffees:--->${state.data}")
                }

                is RequestState.FailureState -> {
                    setState(
                        CoffeeListUIState(
                            error = state.data
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}
