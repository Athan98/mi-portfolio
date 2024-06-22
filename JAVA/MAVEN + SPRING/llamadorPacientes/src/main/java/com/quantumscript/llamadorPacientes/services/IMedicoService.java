package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Medico;
import java.util.List;

public interface IMedicoService {

    public List<Medico> getMedicos();

    public void saveMedico(Medico m);

    public void deleteMedico(Long id);

    public Medico findMedico(Long id);

    public void editMedico(Medico m);

}
