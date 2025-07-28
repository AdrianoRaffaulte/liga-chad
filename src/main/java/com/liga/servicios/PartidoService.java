package com.liga.servicios;

import com.liga.interfaces.IPartidoService;
import com.liga.modelo.Jugador;
import com.liga.modelo.Partido;

import java.util.ArrayList;
import java.util.List;

public class PartidoService implements IPartidoService {

    private List<Partido> partidos = new ArrayList<>();

    @Override
    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    @Override
    public void asignarGol(Partido partido, Jugador jugador, int cantidad) {
        partido.asignarGol(jugador, cantidad);
    }

    @Override
    public List<Partido> listarPartidos() {
        return partidos;
    }
}
