package com.code.code.model;

import java.text.DecimalFormat;
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
@Table(name = "Promedio")
public class Promedio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPromedio;
    
    @Column(name = "promedio", nullable = false)
    private DecimalFormat promedio;

    
    //Nota dependera de promedio
    @OneToMany(mappedBy = "promedio", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("promedio")
    private List<Nota> nota;
    
    //promedio depende de materia (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMateria", nullable = false)
    @JsonIgnoreProperties("Promedio")
    private Materia materia;
    
    //promedio depende de estudiante (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstudiante", nullable = false)
    @JsonIgnoreProperties("Promedio")
    private Estudiante estudiante;
    
    
    public Long getIdPromedio() {
        return idPromedio;
    }
    
    public void setIdPromedio(Long idPromedio) {
        this.idPromedio = idPromedio;
    }
    
    public DecimalFormat getPromedio() {
        return promedio;
    }
    
    public void setPromedio(DecimalFormat promedio) {
        this.promedio = promedio;
    }
    
    
}
