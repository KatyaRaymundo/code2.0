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
@Table(name = "Horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @Column(name = "teorico_horario", length = 50, nullable = false)
    private String teoricoHorario;

    @Column(name = "discusion_horario", length = 50, nullable = false)
    private String discusionHorario;

    // horario depende de materia (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMateria", nullable = false)
    @JsonIgnoreProperties("Horario")
    private Materia materia;

    // inscribir dependera de materia
    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("horario")
    private List<Inscribir> inscribir;

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getTeoricoHorario() {
        return teoricoHorario;
    }

    public void setTeoricoHorario(String teoricoHorario) {
        this.teoricoHorario = teoricoHorario;
    }

    public String getDiscusionHorario() {
        return discusionHorario;
    }

    public void setDiscusionHorario(String discusionHorario) {
        this.discusionHorario = discusionHorario;
    }
}
