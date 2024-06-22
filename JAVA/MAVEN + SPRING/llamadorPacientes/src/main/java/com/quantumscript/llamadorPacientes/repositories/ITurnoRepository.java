package com.quantumscript.llamadorPacientes.repositories;

import com.quantumscript.llamadorPacientes.models.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {

}
