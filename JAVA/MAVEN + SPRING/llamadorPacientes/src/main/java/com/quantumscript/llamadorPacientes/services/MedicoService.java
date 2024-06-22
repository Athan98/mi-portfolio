
package com.quantumscript.llamadorPacientes.services;

import com.quantumscript.llamadorPacientes.models.Medico;
import com.quantumscript.llamadorPacientes.repositories.IMedicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService implements IMedicoService{

    @Autowired
    private IMedicoRepository mr;
    
    @Override
    public List<Medico> getMedicos() {
        return mr.findAll();
    }

    @Override
    public void saveMedico(Medico m) {
        mr.save(m);
    }

    @Override
    public void deleteMedico(Long id) {
        mr.deleteById(id);
    }

    @Override
    public Medico findMedico(Long id) {
        return mr.findById(id).orElse(null);
    }

    @Override
    public void editMedico(Medico m) {
        this.saveMedico(m);
    }
    
}
