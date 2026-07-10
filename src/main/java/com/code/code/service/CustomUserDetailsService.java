package com.code.code.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.code.code.Repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correoUsuario) throws UsernameNotFoundException {
        return usuarioRepository.findByCorreoUsuario(correoUsuario).orElseThrow(
                () -> new UsernameNotFoundException("Alumno no encontrado con el correo: " + correoUsuario));
    }

}
