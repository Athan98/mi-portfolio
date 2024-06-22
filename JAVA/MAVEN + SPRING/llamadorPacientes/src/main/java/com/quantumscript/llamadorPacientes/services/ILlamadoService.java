package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Llamado;
import java.util.List;

public interface ILlamadoService {

    public List<Llamado> getLlamados();

    public void saveLlamado(Llamado l);

    public void deleteLlamado(Long id);

    public Llamado findLlamado(Long id);

    public void editLlamado(Llamado l);

    public List<Llamado> getUltimosDosLlamados();

}
