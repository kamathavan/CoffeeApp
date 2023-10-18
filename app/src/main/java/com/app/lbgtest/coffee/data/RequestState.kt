package com.app.lbgtest.coffee.data

sealed class RequestState<T> {
    class Loading<T> : RequestState<T>()

    data class SuccessState<T>(val data: T) : RequestState<T>()

    data class FailureState<T>(val data: String) : RequestState<T>()
}