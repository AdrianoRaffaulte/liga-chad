package com.liga.app;

import com.liga.modelo.*;
import com.liga.servicios.*;

public class MainTest {
    public static void main(String[] args) {
        JugadorService jugadorService = new JugadorService();
        EquipoService equipoService = new EquipoService();

        // Crear jugadores
        Jugador juan = new JugadorTitular("Julian", 21);
        Jugador pedro = new JugadorSuplente("Gonzalo", 20);

        jugadorService.registrarJugador(juan);
        jugadorService.registrarJugador(pedro);

        jugadorService.listarJugadores();

        // Crear equipos
        equipoService.crearEquipo("INFO FC");
        equipoService.crearEquipo("MAVEN FC");

        // Asignar jugadores
        equipoService.agregarJugadorAEquipo("INFO FC", juan);
        equipoService.agregarJugadorAEquipo("MAVEN FC", pedro);

        System.out.println("\nEquipos registrados:");
        for (Equipo e : equipoService.listarEquipos()) {
            System.out.println(e);
        }
    }
}
