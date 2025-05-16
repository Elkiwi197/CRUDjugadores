package com.example.crudjugadores.domain.usecases

import com.example.crudjugadores.dao.JugadoresRepository
import javax.inject.Inject

class DeleteJugadorUseCase @Inject constructor() {
    operator fun invoke(id: Int){
        JugadoresRepository.deleteJugador(id)
    }
}