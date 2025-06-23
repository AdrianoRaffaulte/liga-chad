package com.liga.servicios;

import com.liga.interfaces.JugadorService;
import com.liga.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorServiceImpl implements JugadorService {

    private List<Jugador> jugadores = new ArrayList<>();

    @Override
    public void registrarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    @Override
    public void listarJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    @Override
    public Jugador buscarPorNombre(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
