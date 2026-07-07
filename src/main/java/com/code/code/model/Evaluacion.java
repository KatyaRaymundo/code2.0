package com.code.code.model;


import java.util.Date;
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
@Table(name = "Evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvaluacion;
    
    @Column(name = "nombre_evaluacion", length = 50, nullable = false)
    private String nombreEvaluacion;

    @Column(name = "porcentaje_evaluación", length = 4, nullable = false)
    private String porcentajeEvaluacion;
    
    @Column(name = "fecha_evaluacion", nullable = false)
    private Date fechaEvaluacion;
    
    //nota dependerá de evaluación
    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("evaluacion")
    private List<Nota> nota;
    
    //evaluación depende de programa (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPrograma", nullable = false)
    @JsonIgnoreProperties("Evaluacion")
    private Programa programa;
    
    public Long getIdEvaluacion() {
        return idEvaluacion;
    }
    
    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }
    
    public String getNombreEvaluacion() {
        return nombreEvaluacion;
    }
    
    public void setNombreEvaluacion(String nombreEvaluacion) {
        this.nombreEvaluacion = nombreEvaluacion;
    }
    
    
    public String getPorcentajeEvaluacion() {
        return porcentajeEvaluacion;
    }
    
    public void setPorcentajeEvaluacion(String porcentajeEvaluacion) {
        this.porcentajeEvaluacion = porcentajeEvaluacion;
    }
    
    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
