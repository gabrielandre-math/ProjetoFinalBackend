package com.gabriel.smarorder;

import com.gabriel.smarorder.domain.enums.Perfil;
import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.repositories.ChefeCozinhaRepository;
import com.gabriel.smarorder.repositories.ClienteRepository;
import com.gabriel.smarorder.repositories.ComandaRepository;
import com.gabriel.smarorder.repositories.GarcomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SmarorderApplication implements CommandLineRunner {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private GarcomRepository garcomRepository;
	@Autowired
	private ChefeCozinhaRepository chefeCozinhaRepository;
	@Autowired
	private ComandaRepository comandaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SmarorderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ChefeCozinha chefeCozinha =
				new ChefeCozinha(null, "Joao Carlos",
						"63653730268", "joao@mail.com",
						"123456", "93999999");
		chefeCozinha.addPerfil(Perfil.ADMIN);


		Cliente cliente =
				new Cliente(null, "Pablo Andrade",
						"62653230268", "pablo@mail.com",
						"1234532", "99992999");
		cliente.addPerfil(Perfil.CLIENTE);


		Garcom garcom =
				new Garcom(null, "Adalmir Jr",
						"63653230258", "adalmir@mail.com",
						"1234532","99992919");
		cliente.addPerfil(Perfil.FUNCIONARIO);

		Comanda comanda =
				new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO,
						"Comanda 01",
						"Nenhuma Observação", chefeCozinha, cliente, garcom);


		// Primeiro, salve todas as entidades referenciadas
		chefeCozinhaRepository.saveAll(Arrays.asList(chefeCozinha));
		garcomRepository.saveAll(Arrays.asList(garcom));
		clienteRepository.saveAll(Arrays.asList(cliente));

		// Agora, salve a entidade principal, Comanda
		comandaRepository.saveAll(Arrays.asList(comanda));





	}
}
