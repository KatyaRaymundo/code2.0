package com.code.code.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.code.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoUsuario(String correoUsuario);
}
