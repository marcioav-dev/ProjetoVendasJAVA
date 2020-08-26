package com.br11.sistemavendas.services;

import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
       return obj.get();
    }

    public Usuario inserir(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id){
        usuarioRepository.deleteById(id);
    }

    private void atualizarDados(Usuario entity, Usuario usuario){
        entity.setNomeCompleto(usuario.getNomeCompleto());
        entity.setEmail(usuario.getEmail());
        entity.setNomeUsuario(usuario.getNomeUsuario());
        entity.setSenha(usuario.getSenha());
        entity.setTelefone(usuario.getTelefone());
    }

    public Usuario atualizar(Long id, Usuario usuario){
        Usuario entity = usuarioRepository.getOne(id);
        atualizarDados(entity, usuario);
        return usuarioRepository.save(entity);
    }
}
