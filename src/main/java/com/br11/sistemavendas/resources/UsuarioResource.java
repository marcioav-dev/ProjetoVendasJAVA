package com.br11.sistemavendas.resources;

import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> retornaTodos(){
        List<Usuario> list = service.buscaTodos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> retornaId(@PathVariable Long id){
        Usuario obj = service.buscaPorId(id);
        return ResponseEntity.ok().body(obj);
    }
}
