package com.liga.modelo;

public class JugadorSuplente extends Jugador {

    private int partidosDesdeElBanco;

    public JugadorSuplente(String nombre, int edad, int goles, int partidosDesdeElBanco) {
        super(nombre, edad, goles);
        this.partidosDesdeElBanco = partidosDesdeElBanco;
    }

    public int getPartidosDesdeElBanco() {
        return partidosDesdeElBanco;
    }

    @Override
    public String getTipo() {
        return "Suplente";
    }

    @Override
    public String toString() {
        return super.toString() + " - Partidos desde el banco: " + partidosDesdeElBanco;
    }
}
