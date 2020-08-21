package com.br11.sistemavendas.repositories;

import com.br11.sistemavendas.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
