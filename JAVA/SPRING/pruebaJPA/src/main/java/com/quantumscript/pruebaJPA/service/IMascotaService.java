package com.quantumscript.pruebaJPA.service;

import com.quantumscript.pruebaJPA.model.Mascota;
import java.util.List;

public interface IMascotaService {

    //ENCONTRAR TODAS
    public List<Mascota> getMascotas();

    //ALTA
    public void saveMascota(Mascota mascota);

    //ELIMINAR
    public void deleteMascota(Long id);

    //ENCONTRAR UNA SOLA PERSONA
    public Mascota findMascota(Long id);

    //MODIFICACION
    public void editMascota(Long id,
            Long idNueva,
            String nuevoNombre,
            String nuevaEspecie,
            String nuevaRaza,
            String nuevoColor
    );

}
