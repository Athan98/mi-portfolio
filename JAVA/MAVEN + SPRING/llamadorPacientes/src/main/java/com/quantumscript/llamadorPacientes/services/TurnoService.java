package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Medico;
import com.quantumscript.llamadorPacientes.models.Paciente;
import com.quantumscript.llamadorPacientes.models.Turno;
import com.quantumscript.llamadorPacientes.repositories.ITurnoRepository;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository tr;

    @Override
    public List<Turno> getTurnos() {
        return tr.findAll();
    }

    @Override
    public void saveTurno(Turno t) {
        tr.save(t);
    }

    @Override
    public void deleteTurno(Long id) {
        tr.deleteById(id);
    }

    @Override
    public Turno findTurno(Long id) {
        Turno t = tr.findById(id).orElse(null);
        return t;
    }

    @Override
    public List<Turno> findTurnosPaciente(Paciente p) {
        List<Turno> turnos = this.getTurnos();
        List<Turno> turnosPaciente = new ArrayList<>();

        for (Turno t : turnos) {
            if (t.getPaciente().getId_paciente() == p.getId_paciente()) {
                turnosPaciente.add(t);
            }
        }

        return turnosPaciente;
    }

    @Override
    public List<Turno> findTurnosMedico(String fecha, Long id_medico) {
        List<Turno> turnos = this.getTurnos();
        List<Turno> turnosMedico = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTurno = "";

        for (Turno t : turnos) {
            fechaTurno = dateFormat.format(t.getFecha());
            if (t.getMedico().getId_medico() == id_medico && fechaTurno.equals(fecha)) {
                turnosMedico.add(t);
            }
        }

        return turnosMedico;
    }

    @Override
    public void editTurno(Turno t) {
        this.saveTurno(t);
    }

}
