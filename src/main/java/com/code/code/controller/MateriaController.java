package com.code.code.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.code.Repository.CarreraRepository;
import com.code.code.Repository.DocenteRepository;
import com.code.code.Repository.MateriaRepository;
import com.code.code.model.Carrera;
import com.code.code.model.Docente;
import com.code.code.model.Materia;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/materia")
@AllArgsConstructor
public class MateriaController {

    private DocenteRepository docenteRepository;
    private MateriaRepository materiaRepository;
    private CarreraRepository carreraRepository;

    @GetMapping("/materias")
    public ResponseEntity<?> obtenerMaterias(Authentication authentication) {
        String correoDocente = authentication.getName();

        return docenteRepository.findBycorreoUsuario(correoDocente)
                .map(Docente::getMaterias)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crearMateria")
    public ResponseEntity<?> crearMateria(Authentication authentication, @RequestBody Materia nuevaMateria) {
        String correoDocente = authentication.getName();
        try {
            Optional<Docente> docente = docenteRepository.findBycorreoUsuario(correoDocente);
            Optional<Carrera> carrera = carreraRepository.findById(1L);
            nuevaMateria.setCarrera(carrera.get());
            nuevaMateria.setDocente(docente.get());
            System.err.println(nuevaMateria.getPrerequisitoMateria());
            Materia materia = materiaRepository.save(nuevaMateria);
            return ResponseEntity.status(HttpStatus.CREATED).body(materia);
        } catch (Exception e) {
            System.err.println("Error: " + e);
            return ResponseEntity.badRequest().build();
        }
    }
}
