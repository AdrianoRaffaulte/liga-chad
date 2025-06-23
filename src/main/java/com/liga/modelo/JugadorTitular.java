package com.liga.modelo;

public class JugadorTitular extends Jugador {
    private int minutosJugados;

    public JugadorTitular(String nombre, int edad, int goles, int minutosJugados) {
        super(nombre, edad, goles);
        this.minutosJugados = minutosJugados;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    @Override
    public String getTipo() {
        return "Titular";
    }

    @Override
    public String toString() {
        return super.toString() + " - Minutos jugados: " + minutosJugados;
    }
}
