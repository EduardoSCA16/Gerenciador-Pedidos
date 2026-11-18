package com.alura.gerenciador_pedidos;

import com.alura.gerenciador_pedidos.principal.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {
	private final Main main;

	public GerenciadorPedidosApplication(Main main) {
		this.main = main;
	}

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		main.executar();
	}
}

