package com.example.crudjugadores.ui.pantallaUpdate

import com.example.crudjugadores.domain.model.Jugador

interface FragmentUpdateEvento {
    class DeleteJugador(val id: Int) : FragmentUpdateEvento
    class UpdateJugador(val jugador: Jugador) : FragmentUpdateEvento
    class GetJugador(val id: Int): FragmentUpdateEvento
}