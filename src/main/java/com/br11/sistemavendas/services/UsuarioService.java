package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscaTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscaPorId(Long id){
       Optional<Usuario> obj = usuarioRepository.findById(id);
       return obj.get();
    }
}
