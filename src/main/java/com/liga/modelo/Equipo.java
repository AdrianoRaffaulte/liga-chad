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

    public void quitarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public int totalGoles() {
        return jugadores.stream().mapToInt(Jugador::getGoles).sum();
    }

    public double promedioGoles() {
        if (jugadores.isEmpty()) return 0;
        return (double) totalGoles() / jugadores.size();
    }

    public JugadorTitular titularConMasMinutos() {
    JugadorTitular titularConMas = null;

    for (Jugador j : jugadores) {
        if (j instanceof JugadorTitular) {
            JugadorTitular titular = (JugadorTitular) j;
            if (titularConMas == null || titular.getMinutosJugados() > titularConMas.getMinutosJugados()) {
                titularConMas = titular;
            }
        }
    }

    return titularConMas;
}


    @Override
    public String toString() {
        return "Equipo: " + nombre + " | Goles: " + totalGoles() + " | Jugadores: " + jugadores.size();
    }
}
