package com.br11.sistemavendas.repositories;

import com.br11.sistemavendas.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
