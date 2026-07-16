package com.code.code.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.code.Repository.DocenteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/docente")
@CrossOrigin("*") // !!! Cambiar despues
@AllArgsConstructor
public class DocenteController {

    private DocenteRepository docenteRepository;

    @GetMapping("/maestro")
    public ResponseEntity<?> obtenerDocente(Authentication authentication) {
        String correo = authentication.getName();
        return docenteRepository.findBycorreoUsuario(correo).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
