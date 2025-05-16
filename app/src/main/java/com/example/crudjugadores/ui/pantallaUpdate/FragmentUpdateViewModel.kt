package com.example.crudjugadores.ui.pantallaUpdate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.domain.usecases.DeleteJugadorUseCase
import com.example.crudjugadores.domain.usecases.GetJugadorByIdUseCase
import com.example.crudjugadores.domain.usecases.UpdateJugadorUseCase
import com.example.crudjugadores.ui.common.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentUpdateViewModel @Inject constructor(
    private val getJugadorByIdUseCase: GetJugadorByIdUseCase,
    private val updateJugadorUseCase: UpdateJugadorUseCase,
    private val deleteJugadorUseCase: DeleteJugadorUseCase
) : ViewModel() {


    private val _uiState = MutableLiveData(FragmentUpdateState())
    val uiState: LiveData<FragmentUpdateState> get() = _uiState
    private var idJugador = 0

    fun handleEvent(event: FragmentUpdateEvento) {
        when (event) {
            is FragmentUpdateEvento.GetJugador -> getJugador(event.id)
            is FragmentUpdateEvento.UpdateJugador -> updateJugador(event.jugador)
            is FragmentUpdateEvento.DeleteJugador -> deleteJugador(event.id)
        }
    }

    private fun getJugador(id: Int) {
        idJugador = id
        val jugador: Jugador? = getJugadorByIdUseCase(id)
        _uiState.value = jugador?.let { _uiState.value?.copy(jugadorUpdate = it) }
    }

    private fun updateJugador(jugador: Jugador) {
        jugador.id = idJugador
        updateJugadorUseCase(jugador)
        _uiState.value = _uiState.value?.copy(event = UiEvent.PopBackStack)
    }

    private fun deleteJugador(id: Int) {
        deleteJugadorUseCase(id)
        _uiState.value = _uiState.value?.copy(event = UiEvent.PopBackStack)
    }


}