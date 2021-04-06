package dev.matt2393.chatejemplo

sealed class Result<out R> {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val ex: Exception): Result<Nothing>()
}