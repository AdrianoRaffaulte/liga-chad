package com.liga.modelo;

public class JugadorTitular extends Jugador {
    private int minutosJugados;

    public JugadorTitular(String nombre, int edad) {
        super(nombre, edad);
        this.minutosJugados = 0;
    }

    public void agregarMinutos(int minutos) {
        this.minutosJugados += minutos;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    @Override
    public String getTipo() {
        return "Titular";
    }
}
