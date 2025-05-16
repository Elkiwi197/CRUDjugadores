package com.example.crudjugadores.ui.pantallaUpdate

import com.example.crudjugadores.domain.model.Jugador
import com.example.crudjugadores.ui.common.UiEvent

data class FragmentUpdateState(
    var jugadorUpdate: Jugador = Jugador(),
    val event: UiEvent? = null
)