package com.liga.servicios;

import com.liga.interfaces.IEquipoService;
import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;

import java.util.ArrayList;
import java.util.List;

public class EquipoService implements IEquipoService {

    private List<Equipo> equipos = new ArrayList<>();

    @Override
    public void crearEquipo(String nombre) {
        equipos.add(new Equipo(nombre));
    }

    @Override
    public void agregarJugadorAEquipo(String nombreEquipo, Jugador jugador) {
        for (Equipo e : equipos) {
            if (e.getNombre().equalsIgnoreCase(nombreEquipo)) {
                e.agregarJugador(jugador);
                return;
            }
        }
        System.out.println("Equipo no encontrado: " + nombreEquipo);
    }

    @Override
    public List<Equipo> listarEquipos() {
        return equipos;
    }
}
