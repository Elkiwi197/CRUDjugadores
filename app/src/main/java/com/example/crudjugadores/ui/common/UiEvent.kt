package com.example.crudjugadores.ui.common

sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}