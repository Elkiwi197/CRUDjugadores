package com.example.crudjugadores.domain.usecases

import com.example.crudjugadores.dao.JugadoresRepository
import com.example.crudjugadores.domain.model.Jugador
import javax.inject.Inject

class AddJugadorUseCase @Inject constructor() {
    operator fun invoke(jugador: Jugador) {
        JugadoresRepository.addJugador(jugador)
    }
}