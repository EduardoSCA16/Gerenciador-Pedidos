package com.alura.gerenciador_pedidos.principal;

import com.alura.gerenciador_pedidos.model.Categoria;
import com.alura.gerenciador_pedidos.model.Produto;
import com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import com.alura.gerenciador_pedidos.repository.PedidoRepository;
import com.alura.gerenciador_pedidos.repository.ProdutoRepository;

import java.util.List;

public class Main {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final PedidoRepository pedidoRepository;

    public Main(ProdutoRepository produtoRepository,
                CategoriaRepository categoriaRepository,
                PedidoRepository pedidoRepository) {

        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public void executar() {
        Categoria categoriaEletronicos = new Categoria("Eletrônicos");
        Categoria categoriaLivros = new Categoria("Livros");

        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos);
        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos);
        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros);
        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros);

        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
        categoriaLivros.setProdutos(List.of(produto3, produto4));

        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));

        System.out.println("Categoria dos produtos:");
        categoriaRepository.findAll().forEach(categoria -> {
            System.out.print("Categoria: " + categoria.getNome());
            categoria.getProdutos().forEach(produto -> {
                System.out.println(", Produto: " + produto.getNome());
            });
        });

        System.out.println("\nPrograma encerrado corretamente!");
    }
}
