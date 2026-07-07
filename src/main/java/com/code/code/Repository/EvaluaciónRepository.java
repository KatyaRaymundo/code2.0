package com.code.code.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.code.model.Evaluacion;

public interface EvaluaciónRepository extends JpaRepository<Evaluacion, Long> {
    
}
