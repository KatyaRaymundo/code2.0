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
@Table(name = "Materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateria;

    @Column(name = "nombre_materia", length = 100, nullable = false)
    private String nombreMateria;

    @Column(name = "codigo_materia", length = 10, nullable = false)
    private String codigoMateria;

    @Column(name = "uv_materia", nullable = false)
    private byte uvMateria;

    @Column(name = "ciclo_materia", length = 20, nullable = false)
    private String cicloMateria;

    @Column(name = "pre_requisito_materia", length = 25, nullable = false)
    private String prerequisitoMateria;

    // promedio dependera de materia
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("materia")
    private List<Promedio> promedio;

    // programa dependera de materia
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("materia")
    private List<Programa> programa;

    // materia depende de docente (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDocente", nullable = false)
    @JsonIgnoreProperties("Materia")
    private Docente docente;

    // materia depende de carrera (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarrera", nullable = false)
    @JsonIgnoreProperties("Materia")
    private Carrera carrera;

    public String getPrerequisitoMateria() {
        return prerequisitoMateria;
    }

    public void setPrerequisitoMateria(String prerequisitoMateria) {
        this.prerequisitoMateria = prerequisitoMateria;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public byte getUvMateria() {
        return uvMateria;
    }

    public void setUvMateria(byte uvMateria) {
        this.uvMateria = uvMateria;
    }

    public String getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(String cicloMateria) {
        this.cicloMateria = cicloMateria;
    }
}
