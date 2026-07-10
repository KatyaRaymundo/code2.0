package com.code.code.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.code.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
