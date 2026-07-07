package com.code.code.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Nota")
public class Nota {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;
    
    @Column(name = "nota", nullable = false)
    private double nota;
    
    
    //Nota depende de evaluación (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEvaluacion", nullable = false)
    @JsonIgnoreProperties("Nota")
    private Evaluacion evaluacion;
    
    //nota depende de promedio (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPromedio", nullable = false)
    @JsonIgnoreProperties("Nota")
    private Promedio promedio;
    
    public Long getIdNota() {
        return idNota;
    }
    
    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
}
