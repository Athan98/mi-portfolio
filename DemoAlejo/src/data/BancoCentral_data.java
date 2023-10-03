package data;

import entidades.*;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BancoCentral_data {

    private JSONArray jSONArray = null;

    public BancoCentral_data(ConexionBancoCentral con) {
        this.jSONArray = con.jsonArray();
    }

    public List obtenerDatosEntreFechas(String fechaInicioStr, String fechaFinStr) {
        List<Inflacion> inflacionList = new ArrayList<>();
        // Parsear las fechas de inicio y fin desde las cadenas de texto
        DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatearFecha);
        LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatearFecha);

        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String fechaAPI = jSONObject.getString("d"); // Asume que "fecha" es el nombre del campo en el JSON
            LocalDate fecha = LocalDate.parse(fechaAPI, formatearFecha);
            // Verificar si la fecha está dentro del rango especificado
            if ((fecha.isAfter(fechaInicio) || fecha.equals(fechaInicio)) && (fecha.isBefore(fechaFin) || fecha.equals(fechaFin))) {
                // Fecha dentro del rango, obtener la tasa de cambio
                double tasaCambio = jSONObject.getDouble("v"); // Asume el nombre del campo correcto
                Inflacion inf = new Inflacion();
                inf.setFecha(fecha);
                inf.setTasa(tasaCambio);
                inflacionList.add(inf);
            }
        }
        return inflacionList;
    }

    public Inflacion obtenerDatoDeUnaFecha(String fechaIngresada) {
        Inflacion inflacion = new Inflacion();
        DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIng = LocalDate.parse(fechaIngresada, formatearFecha);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject json = jSONArray.getJSONObject(i);
            String fechaAPI = json.getString("d");
            LocalDate fecha = LocalDate.parse(fechaAPI, formatearFecha);
            if (fechaIng.isEqual(fecha)) {
                double tasaInflacion = json.getDouble("v");
                inflacion.setFecha(fecha);
                inflacion.setTasa(tasaInflacion);

            }
        }
        return inflacion;
    }

    public Inflacion obtenerInflacionActual() {
        Inflacion inflacion = new Inflacion();
        LocalDate fechaActual = LocalDate.now();

        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject json = jSONArray.getJSONObject(i);
            String fechaAPI = json.getString("d");
            LocalDate fecha = LocalDate.parse(fechaAPI);

            if (fechaActual.isEqual(fecha) || fechaActual.isAfter(fecha)) {
                double tasaInflacion = json.getDouble("v");
                inflacion.setFecha(fecha);
                inflacion.setTasa(tasaInflacion);
            }
        }

        return inflacion;
    }

    public double obtenerInflacionAcumuladaActual() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMesAnterior = fechaActual.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        LocalDate fechaAnterior = fechaMesAnterior.minusYears(1);
        DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        double infAcumulada = 0;

        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String fechaAPI = jSONObject.getString("d"); // Asume que "fecha" es el nombre del campo en el JSON
            LocalDate fecha = LocalDate.parse(fechaAPI, formatearFecha);
            if ((fecha.isAfter(fechaAnterior) || fecha.isEqual(fechaAnterior)) && (fecha.isBefore(fechaMesAnterior) || fecha.isEqual(fechaMesAnterior))) {
                // Fecha dentro del último año, obtener la tasa de cambio
                double tasaCambio = jSONObject.getDouble("v"); // Asume el nombre del campo correcto
                infAcumulada = infAcumulada + tasaCambio;

            }
        }

        return infAcumulada;
    }

    public Inflacion obtenerInflacionInterAnual() {
        Inflacion inflacion = new Inflacion();
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaMesAnterior = fechaActual.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        LocalDate fechaAnterior = fechaMesAnterior.minusYears(1);
        DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String fechaAPI = jSONObject.getString("d"); // Asume que "fecha" es el nombre del campo en el JSON
            LocalDate fecha = LocalDate.parse(fechaAPI, formatearFecha);
            if ((fecha.isAfter(fechaAnterior) || fecha.isEqual(fechaAnterior)) && (fecha.isBefore(fechaMesAnterior) || fecha.isEqual(fechaMesAnterior))) {
                // Fecha dentro del último año, obtener la tasa de cambio
                double tasaCambio = jSONObject.getDouble("v"); // Asume el nombre del campo correcto
                inflacion.setTasa(tasaCambio);
                inflacion.setFecha(fecha);

            }
        }
        return inflacion;
    }

    public Inflacion obtenerInflacionEsperada() {
        Inflacion inflacion = new Inflacion();
        LocalDate fechaActual = LocalDate.now();

        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject json = jSONArray.getJSONObject(i);
            String fechaAPI = json.getString("d");
            LocalDate fecha = LocalDate.parse(fechaAPI);

            if (fechaActual.isEqual(fecha) || fechaActual.isAfter(fecha)) {
                double tasaInflacion = json.getDouble("v");
                inflacion.setFecha(fecha);
                inflacion.setTasa(tasaInflacion);
            }
        }

        return inflacion;
    }

}
