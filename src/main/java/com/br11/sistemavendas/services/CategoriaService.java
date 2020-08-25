package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Categoria;
import com.br11.sistemavendas.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscaTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria buscaPorId(Long id){
       Optional<Categoria> obj = categoriaRepository.findById(id);
       return obj.get();
    }
}
