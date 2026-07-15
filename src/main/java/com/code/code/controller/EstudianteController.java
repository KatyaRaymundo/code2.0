package com.code.code.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.code.Repository.EstudianteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/estudiante")
@CrossOrigin(origins = "*") // ! Cambiar déspues por url de despliegue
@AllArgsConstructor
public class EstudianteController {

    private EstudianteRepository estudianteRepository;

    @GetMapping("/alumno")
    public ResponseEntity<?> obtenerEstudiante(Authentication authentication) {
        String correo = authentication.getName();
        return estudianteRepository.findBycorreoUsuario(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
