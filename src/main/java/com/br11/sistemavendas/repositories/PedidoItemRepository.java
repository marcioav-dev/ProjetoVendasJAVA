package com.br11.sistemavendas.repositories;

import com.br11.sistemavendas.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {
}
