package com.code.code.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.code.Repository.CarreraRepository;
import com.code.code.model.Carrera;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/carreras")
public class CarreraController {
    
    @Autowired
    private CarreraRepository carreraRepository;

    @GetMapping("/verCarrera")
    public List<Carrera> obtenerCarrera() {
        return carreraRepository.findAll();
    }

    @PostMapping("/crearCarrera")
    public Carrera crearCarrera(@RequestBody Carrera nuevaCarrera) {
        
        return carreraRepository.save(nuevaCarrera);
    }
    
    @PutMapping("/editarCarrera/{id}")
    public Carrera editarCarrera(@PathVariable Long id, @RequestBody Carrera editarCarrera) {

        return carreraRepository.findById(id).map(carreraExistente -> {
            carreraExistente.setNombreCarrera(editarCarrera.getNombreCarrera());
            return carreraRepository.save(carreraExistente);
        }).orElseThrow(()->new RuntimeException("Error, Carrera no Encontrada"));
    }
    
}
