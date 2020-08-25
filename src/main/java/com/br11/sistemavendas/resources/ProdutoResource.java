package com.br11.sistemavendas.resources;

import com.br11.sistemavendas.entities.Produto;
import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.services.ProdutoService;
import com.br11.sistemavendas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> retornaTodos(){
        List<Produto> list = service.buscaTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> retornaId(@PathVariable Long id){
        Produto obj = service.buscaPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}
