package com.liga.interfaces;

import com.liga.modelo.Jugador;

public interface JugadorService {
    void registrarJugador(Jugador jugador);
    void listarJugadores();
    Jugador buscarPorNombre(String nombre);
}
