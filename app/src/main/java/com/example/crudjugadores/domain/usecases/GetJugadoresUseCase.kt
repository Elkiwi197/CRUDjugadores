package com.example.crudjugadores.domain.usecases

import com.example.crudjugadores.dao.JugadoresRepository
import com.example.crudjugadores.domain.model.Jugador
import javax.inject.Inject

class GetJugadoresUseCase @Inject constructor() {
    operator fun invoke(): List<Jugador> {
        return JugadoresRepository.getJugadores()
    }
}