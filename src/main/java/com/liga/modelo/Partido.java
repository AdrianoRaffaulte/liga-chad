package com.liga.modelo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;

    // Mapea jugadores con la cantidad de goles que anotaron en este partido
    private Map<Jugador, Integer> golesPorJugador;

    private Date fecha;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Date fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.golesPorJugador = new HashMap<>();
    }

    public void asignarGol(Jugador jugador) {
        golesPorJugador.put(jugador, golesPorJugador.getOrDefault(jugador, 0) + 1);
        jugador.sumarGol();

        if (equipoLocal.getJugadores().contains(jugador)) {
            golesLocal++;
        } else if (equipoVisitante.getJugadores().contains(jugador)) {
            golesVisitante++;
        }
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public Map<Jugador, Integer> getGolesPorJugador() {
        return golesPorJugador;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " " + golesLocal + " - " + golesVisitante + " " + equipoVisitante.getNombre();
    }
}
