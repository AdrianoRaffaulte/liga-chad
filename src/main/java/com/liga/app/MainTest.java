package com.liga.app;

import com.liga.modelo.Jugador;
import com.liga.modelo.JugadorTitular;
import com.liga.modelo.JugadorSuplente;
import com.liga.interfaces.JugadorService;
import com.liga.servicios.JugadorServiceImpl;
import com.liga.interfaces.EquipoService;
import com.liga.servicios.EquipoServiceImpl;

public class MainTest {
    public static void main(String[] args) {
        JugadorService jugadorService = new JugadorServiceImpl();
        EquipoService equipoService = new EquipoServiceImpl();

        // Crear jugadores
        Jugador juan = new JugadorTitular("Julian", 21, 5, 40);
        Jugador pedro = new JugadorSuplente("Gonzalo", 20, 3, 2);

        jugadorService.registrarJugador(juan);
        jugadorService.registrarJugador(pedro);

        // Listar jugadores
        System.out.println("Jugadores registrados:");
        jugadorService.listarJugadores();

        // Crear equipo y agregar jugadores
        equipoService.crearEquipo("INFO FC");
        equipoService.crearEquipo("MAVEN FC");
        equipoService.agregarJugadorAEquipo("INFO FC", juan);
        equipoService.agregarJugadorAEquipo("MAVEN FC", pedro);

        System.out.println("\nEquipos registrados:");
        equipoService.listarEquipos();
    }
}
