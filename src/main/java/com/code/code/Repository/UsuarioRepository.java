package com.code.code.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.code.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
