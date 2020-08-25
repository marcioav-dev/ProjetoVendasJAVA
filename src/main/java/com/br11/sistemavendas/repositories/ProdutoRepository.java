package com.br11.sistemavendas.repositories;

import com.br11.sistemavendas.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
