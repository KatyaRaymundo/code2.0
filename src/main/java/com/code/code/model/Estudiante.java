package com.code.code.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name = "Estudiantes")
public class Estudiante implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    @Column(name = "nombre_estudinate", length = 100, nullable = false)
    private String nombreEstudiante;

    @Column(name = "apellido_estudiante", length = 100, nullable = false)
    private String apellidoEstudiante;

    @Column(name = "fecha_nacimiento_docente", nullable = false)
    private Date fechaNacimientoEstudiante;

    @Column(name = "genero_estudiante", nullable = false)
    private char generoEstudiante;

    @Column(name = "correo_estudinate", length = 100, nullable = false)
    private String correoEstudiante;

    @Column(name = "telefono_estudiante", length = 15, nullable = false)
    private String telefonoEstudiante;

    @Column(name = "carnet_estudiante", length = 10, nullable = false)
    private String carnetEstudiante;

    @Column(name = "clave_estudiante", length = 255, nullable = false)
    private String claveEstudiante;

    @Column(name = "imagen_estudiante", length = 250, nullable = false)
    private String imagenEstudiante;

    @Column(name = "materias_aprobadas_estudiante", nullable = false)
    private byte materiaAprobadaEstudiante;

    // promedio dependerá de estudiante
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estudiante")
    private List<Promedio> promedio;

    // estudinate depende de carrera (llave foranea)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCarrera", nullable = false)
    @JsonIgnoreProperties("estudiantes")
    private Carrera carrera;

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreStudiante() {
        return nombreEstudiante;
    }

    public void setNombreStudiante(String nombreStudiante) {
        this.nombreEstudiante = nombreStudiante;
    }

    public String getApellidoEtudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEtudiante(String apellidoEtudiante) {
        this.apellidoEstudiante = apellidoEtudiante;
    }

    public Date getFechaNacimientoDocente() {
        return fechaNacimientoEstudiante;
    }

    public void setFechaNacimientoDocente(Date fechaNacimientoDocente) {
        this.fechaNacimientoEstudiante = fechaNacimientoDocente;
    }

    public char getGeneroEstudiante() {
        return generoEstudiante;
    }

    public void setGeneroEstudiante(char generoEstudiante) {
        this.generoEstudiante = generoEstudiante;
    }

    public String getCorreoEstudiante() {
        return correoEstudiante;
    }

    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }

    public String getTelefonoEstudiante() {
        return telefonoEstudiante;
    }

    public void setTelefonoEstudiante(String telefonoEstudiante) {
        this.telefonoEstudiante = telefonoEstudiante;
    }

    public String getCarnetEstudiante() {
        return carnetEstudiante;
    }

    public void setCarnetEstudiante(String carnetEstudiante) {
        this.carnetEstudiante = carnetEstudiante;
    }

    public String getClaveEstudiante() {
        return claveEstudiante;
    }

    public void setClaveEstudiante(String claveEstudiante) {
        this.claveEstudiante = claveEstudiante;
    }

    public String getImagenEstudiante() {
        return imagenEstudiante;
    }

    public void setImagenEstudiante(String imagenEstudiante) {
        this.imagenEstudiante = imagenEstudiante;
    }

    public Byte getMateriaAprobadaEstudiante() {
        return materiaAprobadaEstudiante;
    }

    public void setMateriaAprobadaEstudiante(Byte materiaAprobadaEstudiante) {
        this.materiaAprobadaEstudiante = materiaAprobadaEstudiante;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.claveEstudiante;
    }

    @Override
    public String getUsername() {
        return this.correoEstudiante;
    }

}
