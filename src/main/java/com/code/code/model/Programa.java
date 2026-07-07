package com.code.code.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Programa")
public class Programa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrograma;
    
    @Column(name = "evaluaciones_programa", nullable = false)
    private byte evaluacionesPrograma;
    
    //evaluacion dependera de programa
    @OneToMany(mappedBy = "programa", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("programa")
    private List<Evaluacion> evaluacion;
    
    //programa depende de materia (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMateria", nullable = false)
    @JsonIgnoreProperties("Programa")
    private Materia materia;
    
    
    public Long getIdPrograma() {
        return idPrograma;
    }
    
    public void setIdPrograma(Long idPrograma) {
        this.idPrograma = idPrograma;
    }
    
    public byte getEvaluacionesPrograma() {
        return evaluacionesPrograma;
    }
    
    public void setEvaluacionesPrograma(byte evaluacionesPrograma) {
        this.evaluacionesPrograma = evaluacionesPrograma;
    }
}
