package com.liga.servicios;

import com.liga.modelo.Equipo;
import com.liga.modelo.Jugador;
import com.liga.modelo.JugadorTitular;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
// FUNCIONALIDAD 12 Exportar en un archivo .csv los jugadores (Titulares y suplentes) de un equipo dado.

public class ExportadorCSVService {

    public void exportarJugadoresDeEquipo(Equipo equipo) {
        String nombreArchivo = equipo.getNombre().replaceAll(" ", "_") + ".csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(nombreArchivo))) {

            // ESCRIBIR TITULOS DEL EXCEL
            String[] cabecera = { "Es titular", "Nombre", "Edad", "Cantidad de goles" };
            writer.writeNext(cabecera);

            // ESCRIBIR DATOS DE JUGADORES
            List<Jugador> jugadores = equipo.getJugadores();
            for (Jugador j : jugadores) {
                String esTitular = (j instanceof JugadorTitular) ? "SI" : "NO";
                String[] datos = {
                    esTitular,
                    j.getNombre(),
                    String.valueOf(j.getEdad()),
                    String.valueOf(j.getGoles())
                };
                writer.writeNext(datos);
            }

            System.out.println("Archivo CSV exportado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al exportar CSV: " + e.getMessage());
        }
    }
}
