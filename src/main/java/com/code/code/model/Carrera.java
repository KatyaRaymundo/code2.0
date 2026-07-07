package com.code.code.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarrera;
    
    @Column(name = "nombre_carrera", length = 100, nullable = false)
    private String nombreCarrera;
    
    @Column(name = "plan_carrera", length = 5, nullable = false)
    private String planCarrera; 
    
    @Column(name = "cantidad_materias", nullable = false)
    private byte cantidadMaterias;
    
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carrera")
    private List<Estudiante> estudiantes;
    
    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("carrera")
    private List<Materia> materias;
    
    public Carrera(){
        
    }
    
    public Long getIdCarrera() {
        return idCarrera;
    }
    
    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }
    
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    
    public String getPlanCarrera() {
        return planCarrera;
    }
    
    public void setPlanCarrera(String planCarrera) {
        this.planCarrera = planCarrera;
    }

    public Byte getCantidadMaterias() {
        return cantidadMaterias;
    }
    
    public void setCantidadMaterias(Byte cantidadMaterias) {
        this.cantidadMaterias = cantidadMaterias;
    }
}
