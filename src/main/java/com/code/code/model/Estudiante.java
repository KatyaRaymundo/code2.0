package com.code.code.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Estudiantes")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Estudiante extends Usuario {

    @Column(name = "materias_aprobadas_estudiante", nullable = false)
    private byte materiaAprobadaEstudiante;

    // promedio dependerá de estudiante
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estudiante")
    private List<Promedio> promedio;

    // inscribir dependerá de estudiante
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estudiante")
    private List<Inscribir> inscribir;

    // estudiante depende de carrera (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarrera", nullable = false)
    @JsonIgnoreProperties("estudiantes")
    private Carrera carrera;

    public byte getMateriaAprobadaEstudiante() {
        return materiaAprobadaEstudiante;
    }

    public void setMateriaAprobadaEstudiante(byte materiaAprobadaEstudiante) {
        this.materiaAprobadaEstudiante = materiaAprobadaEstudiante;
    }

    public List<Promedio> getPromedio() {
        return promedio;
    }

    public void setPromedio(List<Promedio> promedio) {
        this.promedio = promedio;
    }

    public List<Inscribir> getInscribir() {
        return inscribir;
    }

    public void setInscribir(List<Inscribir> inscribir) {
        this.inscribir = inscribir;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
