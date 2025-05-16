package com.example.crudjugadores.ui.pantallaLista

import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.ui.common.UiEvent

data class FragmentListadoState(
    val jugadores: List<Jugador> = emptyList(),
    val event: UiEvent? = null
)