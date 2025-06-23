package com.liga.interfaces;

import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;

public interface EquipoService {
    void crearEquipo(String nombre);
    void agregarJugadorAEquipo(String nombreEquipo, Jugador jugador);
    void listarEquipos();
    Equipo buscarEquipo(String nombre);
}
