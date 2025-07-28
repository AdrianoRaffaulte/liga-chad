package com.liga.interfaces;

import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;

import java.util.List;

public interface IEquipoService {
    void crearEquipo(String nombre);
    void agregarJugadorAEquipo(String nombreEquipo, Jugador jugador);
    List<Equipo> listarEquipos();
}
