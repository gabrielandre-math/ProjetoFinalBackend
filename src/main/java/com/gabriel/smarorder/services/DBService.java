package com.gabriel.smarorder.services;

import com.gabriel.smarorder.Cliente;
import com.gabriel.smarorder.Comanda;
import com.gabriel.smarorder.Garcom;
import com.gabriel.smarorder.domain.enums.Perfil;
import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.repositories.ClienteRepository;
import com.gabriel.smarorder.repositories.ComandaRepository;
import com.gabriel.smarorder.repositories.GarcomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private GarcomRepository garcomRepository;
    @Autowired
    private ComandaRepository comandaRepository;

    public void instanciaDB() {
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
                        "Nenhuma Observação", cliente, garcom);


        // Primeiro, salve todas as entidades referenciadas

        garcomRepository.saveAll(Arrays.asList(garcom));
        clienteRepository.saveAll(Arrays.asList(cliente));

        // Agora, salve a entidade principal, Comanda
        comandaRepository.saveAll(Arrays.asList(comanda));
    }
}
