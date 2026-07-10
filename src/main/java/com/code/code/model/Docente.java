package com.code.code.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Docentes")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Docente extends Usuario {

    @Column(name = "titulo_docente", length = 150, nullable = false)
    private String tituloDocente;

    // materias dependerá de docente
    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("docente")
    private List<Materia> materias;

    public String getTituloDocente() {
        return tituloDocente;
    }

    public void setTituloDocente(String tituloDocente) {
        this.tituloDocente = tituloDocente;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
