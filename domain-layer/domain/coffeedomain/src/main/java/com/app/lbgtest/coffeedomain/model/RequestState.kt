package com.app.lbgtest.coffeedomain.model

sealed class RequestState<T> {
    data class Loading<T>(val loading: Boolean) : RequestState<T>()

    data class SuccessState<T>(val data: T) : RequestState<T>()

    data class FailureState<T>(val data: String?) : RequestState<T>()
}