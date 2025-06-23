package com.liga.servicios;

import com.liga.interfaces.EquipoService;
import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;

import java.util.HashMap;
import java.util.Map;

public class EquipoServiceImpl implements EquipoService {

    private Map<String, Equipo> equipos = new HashMap<>();

    @Override
    public void crearEquipo(String nombre) {
        if (!equipos.containsKey(nombre)) {
            equipos.put(nombre, new Equipo(nombre));
            System.out.println("Equipo creado: " + nombre);
        } else {
            System.out.println("El equipo " + nombre + " ya existe.");
        }
    }

    @Override
    public void agregarJugadorAEquipo(String nombreEquipo, Jugador jugador) {
        Equipo equipo = equipos.get(nombreEquipo);
        if (equipo != null) {
            equipo.getJugadores().add(jugador);
            System.out.println("Jugador " + jugador.getNombre() + " agregado a " + nombreEquipo);
        } else {
            System.out.println("El equipo " + nombreEquipo + " no existe.");
        }
    }

    @Override
    public void listarEquipos() {
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos registrados.");
            return;
        }
        for (Equipo equipo : equipos.values()) {
            System.out.println("Equipo: " + equipo.getNombre());
            if (equipo.getJugadores().isEmpty()) {
                System.out.println("  No hay jugadores en este equipo.");
            } else {
                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println("  - " + jugador);
                }
            }
        }
    }

    @Override
    public Equipo buscarEquipo(String nombre) {
        return equipos.get(nombre);
    }
}
