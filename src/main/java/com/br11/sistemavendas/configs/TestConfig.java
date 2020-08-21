package com.br11.sistemavendas.configs;

import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario user1 = new Usuario(null , "Marcio Vieira", "marcio@gmail.com", "Knois", "102030", "32101000");
        Usuario user2 = new Usuario(null , "Mirelly Carmo", "mirelly@gmail.com", "Mirelly", "102030", "32102000");

        usuarioRepository.saveAll(Arrays.asList(user1, user2));
    }
}
