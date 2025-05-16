package com.example.crudjugadores.domain.model

data class Jugador(
    var id: Int = 1,
    var nombre: String = "",
    var edad: Int = 0,
    var equipo: String = "",
    var posicion: String = "",
    var valor: Int = 0
)
