package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Pedido;
import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.repositories.PedidoRepository;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> buscaTodos(){
        return pedidoRepository.findAll();
    }

    public Pedido buscaPorId(Long id){
       Optional<Pedido> obj = pedidoRepository.findById(id);
       return obj.get();
    }
}
