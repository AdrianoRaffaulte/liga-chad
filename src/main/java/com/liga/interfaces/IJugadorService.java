package com.liga.interfaces;

import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;

import java.util.List;

public interface IJugadorService {
    void registrarJugador(Jugador jugador);
    void transferirJugador(Jugador jugador, Equipo origen, Equipo destino);
    List<Jugador> obtenerTodosLosJugadores(List<Equipo> equipos);
    Jugador obtenerGoleador(List<Equipo> equipos);
    void listarJugadores();
}
