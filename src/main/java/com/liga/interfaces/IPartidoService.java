package com.liga.interfaces;

import com.liga.modelo.Jugador;
import com.liga.modelo.Partido;

import java.util.List;

public interface IPartidoService {
    void registrarPartido(Partido partido);
    void asignarGol(Partido partido, Jugador jugador, int cantidad);
    List<Partido> listarPartidos();
}
