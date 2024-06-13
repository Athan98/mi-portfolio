package com.quantumscript.pruebaJPA.service;

import com.quantumscript.pruebaJPA.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private IPersonaRepository persoRepo;
}
