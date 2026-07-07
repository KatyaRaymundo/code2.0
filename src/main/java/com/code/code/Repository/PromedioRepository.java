package com.code.code.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.code.model.Promedio;

public interface PromedioRepository extends JpaRepository<Promedio, Long> {
    
}

