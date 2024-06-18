package com.quantumscript.llamadorPacientes.repositories;

import com.quantumscript.llamadorPacientes.models.Llamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILlamadoRepository extends JpaRepository<Llamado, Long> {

}
