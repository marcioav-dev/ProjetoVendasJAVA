package com.br11.sistemavendas.resources;


import com.br11.sistemavendas.entities.Pedido;
import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> retornaTodos(){
        List<Pedido> list = service.buscaTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> retornaId(@PathVariable Long id){
        Pedido obj = service.buscaPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}
