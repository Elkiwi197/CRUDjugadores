package com.example.crudjugadores.ui.pantallaLista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.crudjugadores.domain.usecases.GetJugadoresUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentListadoViewModel @Inject constructor(
    private val getJugadoresUseCase: GetJugadoresUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData(FragmentListadoState())
    val uiState: LiveData<FragmentListadoState> get() = _uiState

    fun handleEvent(event: FragmentListadoEvent) {
        when (event) {
            is FragmentListadoEvent.GetJugadores -> getJugadores()
        }
    }

    private fun getJugadores(){
        _uiState.value = _uiState.value?.copy(jugadores = getJugadoresUseCase.invoke())
    }




}