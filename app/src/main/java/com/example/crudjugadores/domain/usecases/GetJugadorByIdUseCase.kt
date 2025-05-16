package com.example.crudjugadores.domain.usecases

import com.example.crudjugadores.dao.JugadoresRepository
import com.example.crudjugadores.domain.model.Jugador
import javax.inject.Inject

class GetJugadorByIdUseCase @Inject constructor() {
    operator fun invoke(id: Int): Jugador?{
        return JugadoresRepository.getJugadorById(id)
    }
}