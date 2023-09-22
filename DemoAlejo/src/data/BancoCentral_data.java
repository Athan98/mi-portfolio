package data;

import entidades.*;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BancoCentral_data {

    private JSONArray jSONArray = null;

    public BancoCentral_data(ConexionBancoCentral con) {
        this.jSONArray = con.jsonArray();
    }

    public List obtenerDatosFechaAnteriorHastaActualidad(Inflacion inflacion) {
        List<Inflacion> inflacionList = new ArrayList<>();
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaAnterior = inflacion.getFecha();
        DateTimeFormatter formatearFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String fechaAPI = jSONObject.getString("d"); // Asume que "fecha" es el nombre del campo en el JSON
            LocalDate fecha = LocalDate.parse(fechaAPI, formatearFecha);
            if (fecha.isAfter(fechaAnterior) || fecha.isEqual(fechaAnterior)) {
                // Fecha dentro del último año, obtener la tasa de cambio
                double tasaCambio = jSONObject.getDouble("v"); // Asume el nombre del campo correcto
                Inflacion inf = new Inflacion();
                inf.setFecha(fecha);
                inf.setTasa(tasaCambio);
                inflacionList.add(inf);

            }
        }

        return inflacionList;
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
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
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
}
