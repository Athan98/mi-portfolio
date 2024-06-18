package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Paciente;
import com.quantumscript.llamadorPacientes.repositories.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pr;

    @Override
    public List<Paciente> getPacientes() {
        return pr.findAll();
    }

    @Override
    public void savePaciente(Paciente p) {
        pr.save(p);
    }

    @Override
    public void deletePaciente(Long id) {
        pr.deleteById(id);
    }

    @Override
    public Paciente findPaciente(Long id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Paciente p) {
        this.savePaciente(p);
    }

}
