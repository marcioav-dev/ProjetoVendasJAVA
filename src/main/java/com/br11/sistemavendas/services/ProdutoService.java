package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Produto;
import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.repositories.ProdutoRepository;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscaTodos(){
        return produtoRepository.findAll();
    }

    public Produto buscaPorId(Long id){
       Optional<Produto> obj = produtoRepository.findById(id);
       return obj.get();
    }
}
