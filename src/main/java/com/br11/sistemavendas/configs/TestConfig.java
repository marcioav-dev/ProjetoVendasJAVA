package com.br11.sistemavendas.configs;

import com.br11.sistemavendas.entities.Pedido;
import com.br11.sistemavendas.entities.Usuario;
import com.br11.sistemavendas.enums.PedidoStatus;
import com.br11.sistemavendas.repositories.PedidoRepository;
import com.br11.sistemavendas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario user1 = new Usuario(null , "Marcio Vieira", "marcio@gmail.com", "Knois", "102030", "32101000");
        Usuario user2 = new Usuario(null , "Mirelly Carmo", "mirelly@gmail.com", "Mirelly", "102030", "32102000");

        Pedido pedido1 = new Pedido(null, Instant.parse("2020-08-24T16:29:00Z"), PedidoStatus.ENVIADO, user1);
        Pedido pedido2 = new Pedido(null, Instant.parse("2020-08-24T16:33:00Z"), PedidoStatus.ENVIADO, user2);
        Pedido pedido3 = new Pedido(null, Instant.parse("2020-08-24T16:40:00Z"), PedidoStatus.CANCELADO, user2);
        Pedido pedido4 = new Pedido(null, Instant.parse("2020-08-24T16:42:00Z"), PedidoStatus.AGUARDANDO, user1);
        Pedido pedido5 = new Pedido(null, Instant.parse("2020-08-24T16:47:00Z"), PedidoStatus.PGTO_ACEITO, user2);
        Pedido pedido6 = new Pedido(null, Instant.parse("2020-08-24T16:50:00Z"), PedidoStatus.PGTO_ACEITO, user1);
        Pedido pedido7 = new Pedido(null, Instant.parse("2020-08-24T16:53:00Z"), PedidoStatus.AGUARDANDO, user2);

        usuarioRepository.saveAll(Arrays.asList(user1, user2));
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7));
    }
}
