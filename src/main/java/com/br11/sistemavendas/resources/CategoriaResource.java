package com.br11.sistemavendas.resources;

import com.br11.sistemavendas.entities.Categoria;
import com.br11.sistemavendas.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> retornaTodos(){
        List<Categoria> list = service.buscaTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> retornaId(@PathVariable Long id){
        Categoria obj = service.buscaPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}
