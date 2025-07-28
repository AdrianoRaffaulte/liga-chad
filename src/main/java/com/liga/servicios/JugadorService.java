package com.liga.servicios;

import com.liga.interfaces.IJugadorService;
import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class JugadorService implements IJugadorService {

    @Override
    public void registrarJugador(Jugador jugador) {
        System.out.println("Jugador registrado: " + jugador);
    }

    @Override
    public void transferirJugador(Jugador jugador, Equipo origen, Equipo destino) {
        origen.quitarJugador(jugador);
        destino.agregarJugador(jugador);
    }

    @Override
    public List<Jugador> obtenerTodosLosJugadores(List<Equipo> equipos) {
        List<Jugador> todos = new ArrayList<>();
        for (Equipo e : equipos) todos.addAll(e.getJugadores());
        return todos;
    }

    @Override
    public Jugador obtenerGoleador(List<Equipo> equipos) {
        return obtenerTodosLosJugadores(equipos).stream()
            .max((a, b) -> Integer.compare(a.getGoles(), b.getGoles()))
            .orElse(null);
    }

    @Override
    public void listarJugadores() {
        System.out.println("METODO DE EJEMPLO");
    }
}
