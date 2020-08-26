package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Usuario;
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
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> buscaTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscaPorId(Long id){
       Optional<Usuario> obj = usuarioRepository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario inserir(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id){
        try {
            usuarioRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    private void atualizarDados(Usuario entity, Usuario usuario){
        entity.setNomeCompleto(usuario.getNomeCompleto());
        entity.setEmail(usuario.getEmail());
        entity.setNomeUsuario(usuario.getNomeUsuario());
        entity.setSenha(usuario.getSenha());
        entity.setTelefone(usuario.getTelefone());
    }

    public Usuario atualizar(Long id, Usuario usuario){
        try {
            Usuario entity = usuarioRepository.getOne(id);
            atualizarDados(entity, usuario);
            return usuarioRepository.save(entity);
        } catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }
}
