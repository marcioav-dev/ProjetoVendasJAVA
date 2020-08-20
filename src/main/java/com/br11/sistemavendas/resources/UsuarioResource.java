package com.br11.sistemavendas.resources;

import com.br11.sistemavendas.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @GetMapping
    public ResponseEntity<Usuario> retornaTodos(){
        Usuario user = new Usuario(1 , "Marcio Vieira", "marcio@gmail.com", "Knois", "102030", "32101000");
        return ResponseEntity.ok().body(user);
    }
}
