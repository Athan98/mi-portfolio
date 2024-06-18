
package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Llamado;
import com.quantumscript.llamadorPacientes.repositories.ILlamadoRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LlamadoService implements ILlamadoService{

    @Autowired
    private ILlamadoRepository lr;
    
    @Override
    public List<Llamado> getLlamados() {
        return lr.findAll();
    }

    @Override
    public void saveLlamado(Llamado l) {
        lr.save(l);
    }

    @Override
    public void deleteLlamado(Long id) {
        lr.deleteById(id);
    }

    @Override
    public Llamado findLlamado(Long id) {
        return lr.findById(id).orElse(null);
    }

    @Override
    public void editLlamado(Llamado l) {
        this.saveLlamado(l);
    }

   @Override
    public List<Llamado> getUltimosDosLlamados() {
        // Obtener todos los llamados
        List<Llamado> llamados = this.getLlamados();

        // Ordenar los llamados por fechaHora en orden descendente
        List<Llamado> sortedLlamados = llamados.stream()
                .sorted(Comparator.comparing(Llamado::getFechaHoraLlamado).reversed())
                .collect(Collectors.toList());

        // Obtener los dos últimos llamados (los más recientes)
        if (sortedLlamados.size() > 2) {
            return sortedLlamados.subList(0, 2);
        } else {
            return sortedLlamados;
        }
    }
    
}
