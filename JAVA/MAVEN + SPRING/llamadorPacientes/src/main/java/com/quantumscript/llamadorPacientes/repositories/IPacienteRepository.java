
package com.quantumscript.llamadorPacientes.repositories;

import com.quantumscript.llamadorPacientes.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {
    
}
