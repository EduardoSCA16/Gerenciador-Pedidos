package com.alura.gerenciador_pedidos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.TableGenerator;

@Entity
public class Produto {
    private Long id;
    private String nome;
    private Double preco;
}
