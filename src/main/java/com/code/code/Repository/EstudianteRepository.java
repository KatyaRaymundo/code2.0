package com.code.code.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.code.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findBycorreoUsuario(String correo);
}
