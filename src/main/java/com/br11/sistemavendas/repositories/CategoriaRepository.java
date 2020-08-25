package com.br11.sistemavendas.repositories;

import com.br11.sistemavendas.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
