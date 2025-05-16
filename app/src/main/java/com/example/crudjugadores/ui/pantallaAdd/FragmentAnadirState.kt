package com.example.crudjugadores.ui.pantallaAdd

import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.ui.common.UiEvent

data class FragmentAnadirState(
    var jugadorAdd: Jugador = Jugador(),
    val event: UiEvent? = null
)