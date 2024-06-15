package com.quantumscript.pruebaJPA.service;

import com.quantumscript.pruebaJPA.model.Mascota;
import com.quantumscript.pruebaJPA.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRep;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> mascotas = mascoRep.findAll();
        return mascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascoRep.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRep.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota mascota = mascoRep.findById(id).orElse(null);
        return mascota;
    }

    @Override
    public void editMascota(Long id, Long idNueva, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {

        //Buscar el objeto original
        Mascota mascota = this.findMascota(id);
        //Proceso de modificacion a nivel logico
        mascota.setColor(nuevoColor);
        mascota.setEspecie(nuevaEspecie);
        mascota.setNombre(nuevoNombre);
        mascota.setRaza(nuevaRaza);
        mascota.setId_mascota(idNueva);

        //Guardar cambios
        this.saveMascota(mascota);

    }

}
