package com.br11.sistemavendas.configs;

import com.br11.sistemavendas.entities.*;
import com.br11.sistemavendas.enums.PedidoStatus;
import com.br11.sistemavendas.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private PedidoItemRepository pedidoItemRepository;

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

        Categoria categoria1 = new Categoria(null, "Bebidas");
        Categoria categoria2 = new Categoria(null, "Importados");
        Categoria categoria3 = new Categoria(null, "Comidas");
        Categoria categoria4 = new Categoria(null, "SobreMesas");

        Produto produto1 = new Produto(null, "CocaCola Lata", "Bebida feita de cola em lata", 4.0, "notFound");
        Produto produto2 = new Produto(null, "Heineken 600", "Cerveja tipo Lagger", 11.0, "notFound");
        Produto produto3 = new Produto(null, "Espetinho de File", "Melhor Filé do Brasil", 12.5, "notFound");
        Produto produto4 = new Produto(null, "Guaraná Antártica Lata", "Bebida feita de guaraná em lata", 4.0, "notFound");
        Produto produto5 = new Produto(null, "Jack Daniels", "Wiskhy importado", 120.0, "notFound");
        Produto produto6 = new Produto(null, "Tanqueray", "Gim Importado", 99.9, "notFound");
        Produto produto7 = new Produto(null, "Batata Frita", "Porção de batata", 22.0, "notFound");
        Produto produto8 = new Produto(null, "Pudim", "Pudim de Leite", 6.0, "notFound");

        usuarioRepository.saveAll(Arrays.asList(user1, user2));
        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7));
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3, categoria4));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8));

        produto1.getCategorias().add(categoria1);
        produto2.getCategorias().add(categoria1);
        produto3.getCategorias().add(categoria3);
        produto4.getCategorias().add(categoria1);
        produto5.getCategorias().add(categoria1);
        produto5.getCategorias().add(categoria2);
        produto6.getCategorias().add(categoria1);
        produto6.getCategorias().add(categoria2);
        produto7.getCategorias().add(categoria3);
        produto8.getCategorias().add(categoria4);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8));

        PedidoItem pedidoItem1 = new PedidoItem(pedido1, produto1, 1, produto1.getValorUn());
        PedidoItem pedidoItem2 = new PedidoItem(pedido1, produto3, 1, produto1.getValorUn());
        PedidoItem pedidoItem3 = new PedidoItem(pedido1, produto8, 2, produto1.getValorUn());
        PedidoItem pedidoItem4 = new PedidoItem(pedido2, produto2, 10, produto1.getValorUn());
        PedidoItem pedidoItem5 = new PedidoItem(pedido3, produto4, 2, produto1.getValorUn());
        PedidoItem pedidoItem6 = new PedidoItem(pedido4, produto5, 1, produto1.getValorUn());
        PedidoItem pedidoItem7 = new PedidoItem(pedido5, produto6, 2, produto1.getValorUn());
        PedidoItem pedidoItem8 = new PedidoItem(pedido6, produto7, 1, produto1.getValorUn());
        PedidoItem pedidoItem9 = new PedidoItem(pedido7, produto2, 6, produto1.getValorUn());
        PedidoItem pedidoItem10 = new PedidoItem(pedido7, produto7, 1, produto1.getValorUn());

        pedidoItemRepository.saveAll(Arrays.asList(pedidoItem1, pedidoItem2, pedidoItem3, pedidoItem4, pedidoItem5, pedidoItem6, pedidoItem7, pedidoItem8, pedidoItem9, pedidoItem10));

        Pagamento pagamento1 = new Pagamento(null,  Instant.parse("2020-08-24T16:30:00Z"), pedido1);
        pedido1.setPagamento(pagamento1);

        pedidoRepository.save(pedido1);

    }
}
