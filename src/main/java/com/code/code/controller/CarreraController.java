package com.code.code.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.code.Repository.CarreraRepository;
import com.code.code.model.Carrera;

import lombok.RequiredArgsConstructor;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/carreras")
@RequiredArgsConstructor
public class CarreraController {

    private final CarreraRepository carreraRepository;

    private final ObjectMapper objectMapper;

    @GetMapping("/verCarrera")
    public List<Carrera> obtenerCarrera() {
        return carreraRepository.findAll();
    }

    @PostMapping("/crearCarrera")
    public Carrera crearCarrera(@RequestBody Carrera nuevaCarrera) {

        return carreraRepository.save(nuevaCarrera);
    }

    @PutMapping("/editarCarrera/{id}")
    public ResponseEntity<Carrera> editarCarrera(@PathVariable Long id,
            @RequestBody Map<String, Object> camposActualizar) {
        Carrera carrera = carreraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        Map<String, Object> mapa = objectMapper.convertValue(carrera, new TypeReference<Map<String, Object>>() {
        });
        mapa.putAll(camposActualizar);
        Carrera carreraActualizada = objectMapper.convertValue(mapa, Carrera.class);
        Carrera guardada = carreraRepository.save(carreraActualizada);
        return ResponseEntity.ok(guardada);
    }

}
