package com.example.crudjugadores.ui.pantallaAdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.domain.usecases.AddJugadorUseCase
import com.example.crudjugadores.ui.common.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentAnadirViewModel @Inject constructor(
    private val addJugadorUseCase: AddJugadorUseCase,
) : ViewModel() {

    private val _uiState = MutableLiveData(FragmentAnadirState())
    val uiState: LiveData<FragmentAnadirState> get() = _uiState

    fun handleEvent(event: FragmentAnadirEvento) {
        when (event) {
            is FragmentAnadirEvento.AnadirJugador -> addJugador(event.jugador)
        }
    }

    private fun addJugador(jugador: Jugador) {
        addJugadorUseCase(jugador)
        _uiState.value = _uiState.value?.copy(event = UiEvent.PopBackStack)
    }

}