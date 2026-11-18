package com.alura.gerenciador_pedidos.principal;

import com.alura.gerenciador_pedidos.model.Categoria;
import com.alura.gerenciador_pedidos.model.Fornecedor;
import com.alura.gerenciador_pedidos.model.Produto;
import com.alura.gerenciador_pedidos.repository.CategoriaRepository;
import com.alura.gerenciador_pedidos.repository.FornecedorRepository;
import com.alura.gerenciador_pedidos.repository.PedidoRepository;
import com.alura.gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Main {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    Scanner sc = new Scanner(System.in);

    public void executar() {
//        // Criando Categorias
//        Categoria categoriaEletronicos = new Categoria("Eletrônicos");
//        Categoria categoriaLivros = new Categoria("Livros");
//
//        // Criando Fornecedores
//        Fornecedor fornecedorTech = new Fornecedor("Tech Maximus");
//        Fornecedor fornecedorLivros = new Fornecedor("Livraria Global");
//
//        // Criando Produtos
//        Produto produto1 = new Produto("Notebook", 3500.0, categoriaEletronicos, fornecedorTech);
//        Produto produto2 = new Produto("Smartphone", 2500.0, categoriaEletronicos, fornecedorTech);
//        Produto produto3 = new Produto("Livro de Java", 100.0, categoriaLivros, fornecedorLivros);
//        Produto produto4 = new Produto("Livro de Spring Boot", 150.0, categoriaLivros, fornecedorLivros);
//
//        categoriaEletronicos.setProdutos(List.of(produto1, produto2));
//        categoriaLivros.setProdutos(List.of(produto3, produto4));
//
//        // settar fornecedores
//        fornecedorRepository.saveAll(List.of(fornecedorTech, fornecedorLivros));
//
//        categoriaRepository.saveAll(List.of(categoriaEletronicos, categoriaLivros));
//
//        System.out.println("Categoria dos produtos:");
//        categoriaRepository.findAll().forEach(categoria -> {
//            System.out.print("Categoria: " + categoria.getNome());
//            categoria.getProdutos().forEach(produto -> {
//                System.out.println(", Produto: " + produto.getNome());
//            });
//        });

        System.out.println("\nFornecedores dos produtos: ");
        fornecedorRepository.findAll().forEach(fornecedor -> {
            produtoRepository.findAll().forEach(produto -> {
                System.out.print("Produto: " + produto.getNome());
            });
            System.out.println(" - Fornecedor: " + fornecedor.getNome());
        });

        System.out.println("\n\n1. Produtos com preço maior que um valor");

        System.out.print("\nEscolha uma opção: ");
        var opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                produtoComPrecoMaior();
                break;
        }

        System.out.println("\nPrograma encerrado corretamente!");
    }

    public void produtoComPrecoMaior() {
        System.out.print("Digite o preço mínimo: ");
        var precoMin =  sc.nextDouble();
        sc.nextLine();

        List<Produto> produtosMaiores = produtoRepository.buscarProdutosComPrecoMaior(precoMin);

        produtosMaiores.forEach(System.out::println);
    }
}
