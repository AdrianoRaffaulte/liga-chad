package com.liga.modelo;

import java.util.HashMap;
import java.util.Map;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private Map<Jugador, Integer> golesPorJugador;

    public Partido(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesPorJugador = new HashMap<>();
    }

    public void asignarGol(Jugador jugador, int cantidad) {
        golesPorJugador.put(jugador, golesPorJugador.getOrDefault(jugador, 0) + cantidad);
        for (int i = 0; i < cantidad; i++) jugador.anotarGol();
    }

    public Map<Jugador, Integer> getGolesPorJugador() {
        return golesPorJugador;
    }

    @Override
    public String toString() {
        int golesLocal = golesPorEquipo(local);
        int golesVisitante = golesPorEquipo(visitante);
        return local.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + visitante.getNombre();
    }

    private int golesPorEquipo(Equipo equipo) {
        return golesPorJugador.entrySet().stream()
            .filter(e -> equipo.getJugadores().contains(e.getKey()))
            .mapToInt(Map.Entry::getValue).sum();
    }
}
