package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Produto;
import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.repositories.ProdutoRepository;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import com.br11.sistemavendas.services.exceptions.DatabaseException;
import com.br11.sistemavendas.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public Produto inserir(Produto produto){
        return produtoRepository.save(produto);
    }

    public void deletar(Long id){
        try {
            produtoRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void atualizarEstoque(Produto entity, Produto produto){
        entity.setQtdeEstoque(produto.getQtdeEstoque());
    }

    private void atualizarDados(Produto entity, Produto produto){
        entity.setDescricao(produto.getDescricao());
        entity.setNome(produto.getNome());
        entity.setImgUrl(produto.getImgUrl());
        entity.setValorUn(produto.getValorUn());
        entity.setQtdeEstoque(produto.getQtdeEstoque());
    }

    public Produto atualizar(Long id, Produto produto){
        try {
            Produto entity = produtoRepository.getOne(id);
            atualizarDados(entity, produto);
            return produtoRepository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
}
