package com.code.code.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inscribir")
public class Inscribir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdInscribir;

    // estudiante depende de materia (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstudiante", nullable = false)
    @JsonIgnoreProperties("Inscribir")
    private Estudiante estudiante;

    // horario depende de materia (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHorario", nullable = false)
    @JsonIgnoreProperties("Inscribir")
    private Horario horario;

    public Long getIdInscribir() {
        return IdInscribir;
    }

    public void setIdInscribir(Long idInscribir) {
        IdInscribir = idInscribir;
    }
}
