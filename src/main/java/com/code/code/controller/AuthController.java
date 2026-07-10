package com.code.code.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.code.Repository.EstudianteRepository;
import com.code.code.dto.JwtResponse;
import com.code.code.dto.LoginRequest;
import com.code.code.model.Estudiante;
import com.code.code.security.JwtTokenProvider;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // !! Modificar Despues
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private EstudianteRepository estudianteRepository;
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUsuarioEntity(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getPassword()));
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/registrar/estudiante")
    public ResponseEntity<?> registrarUsuario(@RequestBody Estudiante nuevoEstudiante) {
        try {
            String claveLimpia = nuevoEstudiante.getClaveUsuario();
            String claveEncriptada = passwordEncoder.encode(claveLimpia);

            nuevoEstudiante.setClaveUsuario(claveEncriptada);
            nuevoEstudiante.setTipoUsuario("ESTUDIANTE");

            Estudiante estudiante = estudianteRepository.save(nuevoEstudiante);

            return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar " + e.getMessage());
        }
    }
}
