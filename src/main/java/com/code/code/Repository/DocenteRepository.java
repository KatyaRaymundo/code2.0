package com.code.code.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.code.model.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
    Optional<Docente> findBycorreoUsuario(String correoUsuario);
}
