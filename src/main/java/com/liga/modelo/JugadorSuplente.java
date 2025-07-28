package com.liga.modelo;

public class JugadorSuplente extends Jugador {
    private int partidosIngresado;

    public JugadorSuplente(String nombre, int edad) {
        super(nombre, edad);
        this.partidosIngresado = 0;
    }

    public void ingresarPartido() {
        this.partidosIngresado++;
    }

    public int getPartidosIngresado() {
        return partidosIngresado;
    }

    @Override
    public String getTipo() {
        return "Suplente";
    }
}
