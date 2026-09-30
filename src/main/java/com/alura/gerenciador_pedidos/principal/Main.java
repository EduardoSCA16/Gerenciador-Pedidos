package com.alura.gerenciador_pedidos.principal;

import com.alura.gerenciador_pedidos.model.Categoria;
import com.alura.gerenciador_pedidos.model.Pedido;
import com.alura.gerenciador_pedidos.model.Produto;
import com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import com.alura.gerenciador_pedidos.repository.PedidoRepository;
import com.alura.gerenciador_pedidos.repository.ProdutoRepository;

import java.time.LocalDate;

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
        Produto produto = new Produto("Notebook", 3500.0);
        Categoria categoria = new Categoria("Eletrônicos");
        Pedido pedido = new Pedido(LocalDate.now());

        produtoRepository.save(produto);
        categoriaRepository.save(categoria);
        pedidoRepository.save(pedido);

        System.out.println("\nPrograma encerrado corretamente!");
    }
}
