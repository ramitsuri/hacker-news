package com.ramitsuri.forumhub.shared.network

sealed class Result<S, E> {
    data class Success<S, E>(val data: S) : Result<S, E>()

    data class Error<S, E>(val data: E) : Result<S, E>()

    companion object {
        fun <S, E> success(data: S) = Success<S, E>(data)

        fun <S, E> error(data: E) = Error<S, E>(data)
    }
}
