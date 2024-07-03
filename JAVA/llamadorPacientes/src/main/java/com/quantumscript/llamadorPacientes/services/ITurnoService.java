package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Medico;
import com.quantumscript.llamadorPacientes.models.Paciente;
import com.quantumscript.llamadorPacientes.models.Turno;
import java.util.List;

public interface ITurnoService {

    public List<Turno> getTurnos();

    public void saveTurno(Turno t);

    public void deleteTurno(Long id);

    public Turno findTurno(Long id);

    public List<Turno> findTurnosPaciente(Paciente p);

    public List<Turno> findTurnosMedico(Medico m);

    public void editTurno(Turno t);

}
