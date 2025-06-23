package com.liga.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Equipo: " + nombre + "\n");
        for (Jugador j : jugadores) {
            sb.append(" - ").append(j).append("\n");
        }
        return sb.toString();
}

}
