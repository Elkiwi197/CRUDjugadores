package com.example.crudjugadores.dao

import com.example.crudjugadores.domain.model.Jugador

object JugadoresRepository {

    private val jugadores: MutableList<Jugador> = mutableListOf(
        Jugador(1, "Lionel Messi", 36, "Paris Saint-Germain", "Delantero", 100000000),
        Jugador(2, "Cristiano Ronaldo", 38, "Al Nassr", "Delantero", 95000000),
        Jugador(3, "Robert Lewandowski", 34, "FC Barcelona", "Delantero", 85000000),
        Jugador(4, "Kylian Mbappé", 24, "Paris Saint-Germain", "Delantero", 150000000),
        Jugador(5, "Kevin De Bruyne", 32, "Manchester City", "Centrocampista", 90000000),
        Jugador(6, "N'Golo Kanté", 32, "Al-Ittihad", "Centrocampista", 70000000),
        Jugador(7, "Virgil van Dijk", 32, "Liverpool", "Defensor", 85000000),
        Jugador(8, "Marc-André ter Stegen", 31, "FC Barcelona", "Portero", 60000000),
        Jugador(9, "Thibaut Courtois", 31, "Real Madrid", "Portero", 70000000),
        Jugador(10, "Sadio Mané", 31, "Al Nassr", "Delantero", 75000000),
        Jugador(11, "Erling Haaland", 23, "Manchester City", "Delantero", 170000000),
        Jugador(12, "Mohamed Salah", 31, "Liverpool", "Delantero", 85000000),
        Jugador(13, "Luka Modrić", 37, "Real Madrid", "Centrocampista", 50000000),
        Jugador(14, "Sergio Ramos", 37, "Paris Saint-Germain", "Defensor", 40000000),
        Jugador(15, "Harry Kane", 30, "Bayern Munich", "Delantero", 95000000),
        Jugador(16, "Joshua Kimmich", 28, "Bayern Munich", "Centrocampista", 85000000),
        Jugador(17, "David De Gea", 32, "Manchester United", "Portero", 50000000),
        Jugador(18, "Zlatan Ibrahimović", 41, "AC Milan", "Delantero", 20000000),
        Jugador(19, "Karim Benzema", 35, "Al-Ittihad", "Delantero", 70000000),
        Jugador(21, "Raheem Sterling", 28, "Chelsea", "Delantero", 70000000),
        Jugador(22, "Paul Pogba", 30, "Juventus", "Centrocampista", 60000000),
        Jugador(23, "Antonio Rudiger", 30, "Real Madrid", "Defensor", 60000000),
        Jugador(24, "Jadon Sancho", 25, "Manchester United", "Delantero", 80000000),
        Jugador(25, "Phil Foden", 23, "Manchester City", "Centrocampista", 85000000),
        Jugador(26, "Bernardo Silva", 29, "Manchester City", "Centrocampista", 75000000),
        Jugador(27, "Ederson", 29, "Manchester City", "Portero", 65000000),
        Jugador(28, "Ciro Immobile", 33, "Lazio", "Delantero", 60000000),
        Jugador(29, "Mauro Icardi", 30, "Galatasaray", "Delantero", 50000000),
        Jugador(30, "Rodri", 27, "Manchester City", "Centrocampista", 80000000),
        Jugador(31, "Jack Grealish", 28, "Manchester City", "Delantero", 75000000),
        Jugador(32, "Toni Kroos", 34, "Real Madrid", "Centrocampista", 60000000),
        Jugador(33, "Neymar Jr.", 31, "Al Hilal", "Delantero", 80000000),
        Jugador(34, "Jules Koundé", 25, "FC Barcelona", "Defensor", 70000000),
        Jugador(35, "Riyad Mahrez", 33, "Al Ahli", "Delantero", 65000000),
        Jugador(36, "Ángel Di María", 35, "Juventus", "Delantero", 40000000),
        Jugador(37, "Frenkie de Jong", 26, "FC Barcelona", "Centrocampista", 80000000),
        Jugador(38, "Alexandre Lacazette", 32, "Olympique Lyon", "Delantero", 25000000),
        Jugador(39, "Yassine Bounou", 32, "Sevilla FC", "Portero", 50000000),
        Jugador(40, "Wojciech Szczęsny", 33, "Juventus", "Portero", 45000000),
        Jugador(41, "Julian Álvarez", 24, "Manchester City", "Delantero", 65000000),
        Jugador(42, "Dusan Tadic", 35, "Ajax", "Centrocampista", 30000000),
        Jugador(43, "Alisson Becker", 30, "Liverpool", "Portero", 75000000),
        Jugador(45, "Luis Suárez", 36, "Grêmio", "Delantero", 25000000),
        Jugador(46, "Juan Cuadrado", 35, "Juventus", "Centrocampista", 30000000),
        Jugador(47, "Brahim Díaz", 25, "AC Milan", "Centrocampista", 40000000),
        Jugador(48, "Marcelo", 35, "Fluminense", "Defensor", 20000000),
        Jugador(49, "Angelino", 28, "RB Leipzig", "Defensor", 50000000),
        Jugador(50, "Hugo Lloris", 37, "Tottenham Hotspur", "Portero", 40000000))

    fun deleteJugador(id: Int) {
        jugadores.removeIf { it.id == id }
    }

    fun getJugadores(): MutableList<Jugador>{
        return jugadores
    }

    fun getJugadorById(idJugador: Int): Jugador?{
        return jugadores.find { it.id == idJugador }
    }

    fun updateJugador(jugador: Jugador) {
        val jugadorUpdate = jugadores.find { it.id == jugador.id }
        jugadorUpdate.let {
            jugadorUpdate?.nombre = jugador.nombre
            jugadorUpdate?.edad = jugador.edad
            jugadorUpdate?.equipo = jugador.equipo
            jugadorUpdate?.valor = jugador.valor
            jugadorUpdate?.posicion = jugador.posicion
        }
    }

    fun addJugador(jugador: Jugador) {
        var idValido = false
        while (!idValido) {
            if (jugadores.any { it.id == jugador.id }) {
                jugador.id += 1
            } else {
                idValido = true
            }
        }
        jugadores.add(jugador)
    }
}

