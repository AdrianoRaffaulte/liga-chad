package com.liga.modelo;

public abstract class Jugador {
    protected String nombre;
    protected int edad;
    protected int goles;

    public Jugador(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.goles = 0;
    }

    public abstract String getTipo();

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getGoles() {
        return goles;
    }

    public void anotarGol() {
        goles++;
    }

    @Override
    public String toString() {
        return getTipo() + ": " + nombre + " (" + edad + " años) - Goles: " + goles;
    }
}
