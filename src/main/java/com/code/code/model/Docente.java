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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Docentes")
public class Docente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocente;

    @Column(name = "nombre_docente", length = 100, nullable = false)
    private String nombreDocente;

    @Column(name = "apellido_docente", length = 100, nullable = false)
    private String apellidoDocente;

    @Column(name = "fecha_nacimiento_docente", nullable = false)
    private Date fechaNacimientoDocente;

    @Column(name = "genero_docente", nullable = false)
    private char generoDocente;

    @Column(name = "correo_docente", length = 150, nullable = false)
    private String correoDocente;

    @Column(name = "telefono_docente", length = 15, nullable = false)
    private String telefonoDocente;

    @Column(name = "carnet_docente", length = 10, nullable = false)
    private String carnetDocente;

    @Column(name = "titulo_docente", length = 150, nullable = false)
    private String tituloDocente;

    @Column(name = "clave_docente", length = 255, nullable = false)
    private String claveDocente;

    @Column(name = "imagen_docente", length = 250, nullable = false)
    private String imagenDocente;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("docente")
    private List<Materia> materias;

    public Long getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Long idDocente) {
        this.idDocente = idDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public Date getFechaNacimientoDocente() {
        return fechaNacimientoDocente;
    }

    public void setFechaNacimientoDocente(Date fechaNacimientoDocente) {
        this.fechaNacimientoDocente = fechaNacimientoDocente;
    }

    public char getGeneroDocente() {
        return generoDocente;
    }

    public void setGeneroDocente(char generoDocente) {
        this.generoDocente = generoDocente;
    }

    public String getCorreoDocente() {
        return correoDocente;
    }

    public void setCorreoDocente(String correoDocente) {
        this.correoDocente = correoDocente;
    }

    public String getTelefonoDocente() {
        return telefonoDocente;
    }

    public void setTelefonoDocente(String telefonoDocente) {
        this.telefonoDocente = telefonoDocente;
    }

    public String getCarnetDocente() {
        return carnetDocente;
    }

    public void setCarnetDocente(String carnetDocente) {
        this.carnetDocente = carnetDocente;
    }

    public String getTituloDocente() {
        return tituloDocente;
    }

    public void setTituloDocente(String tituloDocente) {
        this.tituloDocente = tituloDocente;
    }

    public String getClaveDocente() {
        return claveDocente;
    }

    public void setClaveDocente(String claveDocente) {
        this.claveDocente = claveDocente;
    }

    public String getImagenDocente() {
        return imagenDocente;
    }

    public void setImagenDocente(String imagenDocente) {
        this.imagenDocente = imagenDocente;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.claveDocente;
    }

    @Override
    public String getUsername() {
        return this.correoDocente;
    }

}
