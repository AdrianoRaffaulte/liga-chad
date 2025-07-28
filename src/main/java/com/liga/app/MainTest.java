package com.liga.app;

import com.liga.modelo.*;
import com.liga.servicios.*;

import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        // Servicios
        JugadorService jugadorService = new JugadorService();
        EquipoService equipoService = new EquipoService();
        PartidoService partidoService = new PartidoService();

        // FUNCIONALIDAD 1: Registrar jugadores titulares o suplentes
        Jugador juan = new JugadorTitular("Julian", 21);
        Jugador pedro = new JugadorSuplente("Gonzalo", 20);
        ((JugadorTitular) juan).agregarMinutos(90);
        ((JugadorSuplente) pedro).ingresarPartido();
        jugadorService.registrarJugador(juan);
        jugadorService.registrarJugador(pedro);

        // FUNCIONALIDAD 2: Crear equipos e incorporar jugadores
        equipoService.crearEquipo("INFO FC");
        equipoService.crearEquipo("MAVEN FC");
        equipoService.agregarJugadorAEquipo("INFO FC", juan);
        equipoService.agregarJugadorAEquipo("MAVEN FC", pedro);

        // FUNCIONALIDAD 3: Registrar partidos entre equipos
        Equipo infoFC = equipoService.listarEquipos().get(0);
        Equipo mavenFC = equipoService.listarEquipos().get(1);
        Partido partido = new Partido(infoFC, mavenFC);
        partidoService.registrarPartido(partido);

        // FUNCIONALIDAD 4: Asignar goles a jugadores durante un partido
        partidoService.asignarGol(partido, juan, 2);
        partidoService.asignarGol(partido, pedro, 1);

        // FUNCIONALIDAD 5: Mostrar listado de todos los jugadores y su tipo
        System.out.println("\n--- FUNCIONALIDAD 5: Listado de jugadores ---");
        for (Equipo equipo : equipoService.listarEquipos()) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (Jugador j : equipo.getJugadores()) {
                System.out.println("  - " + j);
            }
        }

        // FUNCIONALIDAD 6: Calcular y mostrar el goleador de la liga
        System.out.println("\n--- FUNCIONALIDAD 6: Goleador de la liga ---");
        Jugador goleador = jugadorService.obtenerGoleador(equipoService.listarEquipos());
        System.out.println("Goleador: " + goleador);

        // FUNCIONALIDAD 7: Mostrar promedio de goles por equipo
        System.out.println("\n--- FUNCIONALIDAD 7: Promedio de goles por equipo ---");
        for (Equipo e : equipoService.listarEquipos()) {
            System.out.println(e.getNombre() + " - Promedio: " + e.promedioGoles());
        }

        // FUNCIONALIDAD 8: Ranking de equipos por cantidad de goles anotados
        System.out.println("\n--- FUNCIONALIDAD 8: Ranking de equipos por goles ---");
        List<Equipo> ranking = equipoService.listarEquipos();
        ranking.sort((a, b) -> b.totalGoles() - a.totalGoles());
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println((i + 1) + ". " + ranking.get(i).getNombre() + " - Goles: " + ranking.get(i).totalGoles());
        }

        // FUNCIONALIDAD 9: Transferir un jugador de un equipo a otro
        System.out.println("\n--- FUNCIONALIDAD 9: Transferencia de jugador ---");
        jugadorService.transferirJugador(pedro, mavenFC, infoFC);
        System.out.println("Jugador transferido. Nuevo estado:");
        for (Equipo e : equipoService.listarEquipos()) {
            System.out.println("Equipo: " + e.getNombre());
            for (Jugador j : e.getJugadores()) {
                System.out.println("  - " + j);
            }
        }

        // FUNCIONALIDAD 10: Mostrar suplentes que nunca hayan ingresado
        System.out.println("\n--- FUNCIONALIDAD 10: Suplentes que nunca ingresaron ---");
        JugadorSuplente suplenteNuevo = new JugadorSuplente("Ramiro", 19);
        equipoService.agregarJugadorAEquipo("MAVEN FC", suplenteNuevo);
        for (Equipo e : equipoService.listarEquipos()) {
            for (Jugador j : e.getJugadores()) {
                if (j instanceof JugadorSuplente js && js.getPartidosIngresado() == 0) {
                    System.out.println("Suplente sin ingresar: " + js.getNombre() + " (Equipo: " + e.getNombre() + ")");
                }
            }
        }

        // FUNCIONALIDAD 11: Mostrar jugador titular con más minutos jugados
        System.out.println("\n--- FUNCIONALIDAD 11: Titular con más minutos jugados ---");
        for (Equipo e : equipoService.listarEquipos()) {
            JugadorTitular t = e.titularConMasMinutos();
            if (t != null) {
                System.out.println("Equipo: " + e.getNombre() + " - Titular con más minutos: " + t.getNombre() + " (" + t.getMinutosJugados() + " min)");
            }
        }

        // FUNCIONALIDAD 12 Exportar en un archivo .csv los jugadores (Titulares y suplentes) de un equipo dado.
        ExportadorCSVService exportador = new ExportadorCSVService();
        Equipo equipo = equipoService.listarEquipos().get(0);
        exportador.exportarJugadoresDeEquipo(equipo);

    }
}
