package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.models.Cliente;
import com.gabriel.smarorder.domain.models.Comanda;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.domain.enums.Perfil;
import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.repositories.ClienteRepository;
import com.gabriel.smarorder.repositories.ComandaRepository;
import com.gabriel.smarorder.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private PasswordEncoder encoder;


    public void instanciaDB() {

        // Criando Clientes com CPFs válidos
        Cliente cliente1 = new Cliente(null, "Pablo Andrade", "188.026.260-65", "pablo@mail.com", encoder.encode("123"), "99992999");
        Cliente cliente2 = new Cliente(null, "Ana Beatriz", "494.402.700-12", "ana@mail.com", encoder.encode("654321"), "98887766");
        Cliente cliente3 = new Cliente(null, "Carlos Souza", "651.883.530-32", "carlos@mail.com", encoder.encode("789456"), "97776655");

        cliente1.addPerfil(Perfil.CLIENTE);
        cliente2.addPerfil(Perfil.CLIENTE);
        cliente3.addPerfil(Perfil.CLIENTE);

        // Criando Funcionários com CPFs válidos
        Funcionario funcionario1 = new Funcionario(null, "Adalmir Jr", "970.721.800-28", "adalmir@mail.com", encoder.encode("1234532"), "99992919");
        Funcionario funcionario2 = new Funcionario(null, "Maria Silva", "259.888.540-60", "maria@mail.com", encoder.encode("456789"), "98888777");
        Funcionario funcionario3 = new Funcionario(null, "João Mendes", "742.809.090-32", "joao@mail.com", encoder.encode("123789"), "96665544");
        Funcionario funcionario4 = new Funcionario(null, "Max Hargreeves", "580.144.330-41", "max@mail.com", encoder.encode("123789"), "96665524");

        funcionario1.addPerfil(Perfil.FUNCIONARIO);
        funcionario2.addPerfil(Perfil.FUNCIONARIO);
        funcionario3.addPerfil(Perfil.FUNCIONARIO);
        funcionario4.addPerfil(Perfil.FUNCIONARIO);

        // Criando Comandas
        Comanda comanda1 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 01", "Nenhuma Observação", cliente1, funcionario1);
        Comanda comanda2 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 02", "Adicionar pouco sal", cliente2, funcionario2);
        Comanda comanda3 = new Comanda(null, Prioridade.BAIXA, Status.ENCERRADO, "Comanda 03", "Nenhuma Observação", cliente3, funcionario3);
        Comanda comanda4 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 04", "Sem cebola", cliente1, funcionario3);
        Comanda comanda5 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 05", "Sem glúten", cliente2, funcionario1);

        // Salvar todas as entidades no repositório
        funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4));
        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
        comandaRepository.saveAll(Arrays.asList(comanda1, comanda2, comanda3, comanda4, comanda5));
    }
}
