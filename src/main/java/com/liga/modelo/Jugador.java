package com.liga.modelo;

public abstract class Jugador {
    protected String nombre;
    protected int edad;
    protected int goles;

    public Jugador(String nombre, int edad, int goles) {
        this.nombre = nombre;
        this.edad = edad;
        this.goles = goles;
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

    public void sumarGol() {
        this.goles++;
    }

    @Override
    public String toString() {
        return nombre + " (" + getTipo() + ") - Edad: " + edad + ", Goles: " + goles;
    }
}
