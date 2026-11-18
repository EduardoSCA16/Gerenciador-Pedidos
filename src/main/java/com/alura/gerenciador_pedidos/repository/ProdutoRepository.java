package com.alura.gerenciador_pedidos.repository;

import com.alura.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.preco >= :precoMin")
    List<Produto> buscarProdutosComPrecoMaior(double precoMin);
}
