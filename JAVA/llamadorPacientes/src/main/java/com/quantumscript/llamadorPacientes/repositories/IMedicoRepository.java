package com.quantumscript.llamadorPacientes.repositories;

import com.quantumscript.llamadorPacientes.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico, Long> {

}
