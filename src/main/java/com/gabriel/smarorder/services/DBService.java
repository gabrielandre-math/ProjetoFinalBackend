package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.enums.Perfil;
import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.domain.models.*;
import com.gabriel.smarorder.repositories.ClienteRepository;
import com.gabriel.smarorder.repositories.ComandaRepository;
import com.gabriel.smarorder.repositories.FuncionarioRepository;
import com.gabriel.smarorder.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private ProdutoRepository produtoRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void instanciaDB() {

        // Criando produtos
        Produto produto1 = new Produto(null, "Hamburguer", new BigDecimal("15.00"), "Hamburguer artesanal com queijo");
        Produto produto2 = new Produto(null, "Pizza", new BigDecimal("25.00"), "Pizza de calabresa com borda recheada");
        Produto produto3 = new Produto(null, "Pastel", new BigDecimal("8.00"), "Pastel de carne com queijo");
        Produto produto4 = new Produto(null, "Suco", new BigDecimal("5.00"), "Suco de laranja natural");
        Produto produto5 = new Produto(null, "Cerveja", new BigDecimal("7.00"), "Cerveja artesanal");

        // Salvando os produtos no repositório
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));

        // Criando Clientes com CPFs válidos (com comandas em aberto)
        Cliente cliente1 = new Cliente(null, "Pablo Andrade", "227.722.590-80", "pablo1@mail.com", encoder.encode("1234567"), "99992999");
        Cliente cliente2 = new Cliente(null, "Ana Beatriz", "195.951.350-89", "anin@mail.com",encoder.encode("654321"), "98887766");
        Cliente cliente3 = new Cliente(null, "Carlos Souza", "926.519.560-66", "carlos@mail.com", encoder.encode("senha123"), "97776555");
        Cliente cliente4 = new Cliente(null, "Mariana Lima", "554.602.500-05", "mariana@mail.com", encoder.encode("senha456"), "98888888");

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3, cliente4));

        cliente1.addPerfil(Perfil.CLIENTE);
        cliente2.addPerfil(Perfil.CLIENTE);
        cliente3.addPerfil(Perfil.CLIENTE);
        cliente4.addPerfil(Perfil.CLIENTE);

        // Criando Funcionários com CPFs válidos
        Funcionario funcionario1 = new Funcionario(null, "Adalmir Jr", "900.650.710-50", "adalmir@mail.com", encoder.encode("1234563"), "99992919");
        Funcionario funcionario2 = new Funcionario(null, "Maria Silva", "327.396.860-56", "maria@mail.com", encoder.encode("456789"), "98888777");
        Funcionario funcionario3 = new Funcionario(null, "João Mendes", "527.039.530-46", "joao@mail.com", encoder.encode("123456"), "96665544");

        funcionario1.addPerfil(Perfil.FUNCIONARIO);
        funcionario2.addPerfil(Perfil.FUNCIONARIO);
        funcionario3.addPerfil(Perfil.FUNCIONARIO);

        funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2, funcionario3));

        // Admin
        Funcionario funcionarioAdm = new Funcionario(null, "admin", "844.165.670-30", "admin@mail.com", encoder.encode("admin123"), "99992919");
        funcionarioAdm.addPerfil(Perfil.ADMIN);

        funcionarioRepository.save(funcionarioAdm);

        // Criando comandas e adicionando itens a elas, com datas variadas e mesas
        Comanda comanda1 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 01", "Nenhuma Observação", cliente1, funcionario1, "Mesa 01");
        comanda1.setDataAbertura(LocalDate.now().minusMonths(3));  // Comanda de 3 meses atrás
        comanda1.getItens().add(new ItemComanda(null, comanda1, produto1, 2)); // 2 Hamburgueres
        comanda1.getItens().add(new ItemComanda(null, comanda1, produto3, 3)); // 3 Pasteis

        Comanda comanda2 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 02", "Adicionar pouco sal", cliente2, funcionario2, "Mesa 02");
        comanda2.setDataAbertura(LocalDate.now().minusMonths(2));  // Comanda de 2 meses atrás
        comanda2.getItens().add(new ItemComanda(null, comanda2, produto2, 1)); // 1 Pizza

        Comanda comanda3 = new Comanda(null, Prioridade.BAIXA, Status.ANDAMENTO, "Comanda 03", "Sem açúcar", cliente3, funcionario3, "Mesa 03");
        comanda3.setDataAbertura(LocalDate.now().minusMonths(1));  // Comanda de 1 mês atrás
        comanda3.getItens().add(new ItemComanda(null, comanda3, produto4, 2)); // 2 Sucos

        Comanda comanda4 = new Comanda(null, Prioridade.MEDIA, Status.ENCERRADO, "Comanda 04", "Sem cebola", cliente4, funcionario1, "Mesa 04");
        comanda4.setDataAbertura(LocalDate.now());  // Comanda deste mês
        comanda4.getItens().add(new ItemComanda(null, comanda4, produto1, 1)); // 1 Hamburguer
        comanda4.getItens().add(new ItemComanda(null, comanda4, produto5, 2)); // 2 Cervejas

        Comanda comanda5 = new Comanda(null, Prioridade.ALTA, Status.ANDAMENTO, "Comanda 05", "Pouco sal", cliente1, funcionario2, "Mesa 05");
        comanda5.setDataAbertura(LocalDate.now().minusMonths(6));  // Comanda de 6 meses atrás
        comanda5.getItens().add(new ItemComanda(null, comanda5, produto3, 2)); // 2 Pasteis
        comanda5.getItens().add(new ItemComanda(null, comanda5, produto5, 1)); // 1 Cerveja

        // Comandas com status "ABERTO"
        Comanda comanda6 = new Comanda(null, Prioridade.BAIXA, Status.ABERTO, "Comanda 06", "Sem gelo", cliente2, funcionario3, "Mesa 06");
        comanda6.setDataAbertura(LocalDate.now().minusWeeks(1));  // Comanda de 1 semana atrás
        comanda6.getItens().add(new ItemComanda(null, comanda6, produto4, 3)); // 3 Sucos

        Comanda comanda7 = new Comanda(null, Prioridade.MEDIA, Status.ABERTO, "Comanda 07", "Bem passado", cliente3, funcionario1, "Mesa 07");
        comanda7.setDataAbertura(LocalDate.now().minusDays(3));  // Comanda de 3 dias atrás
        comanda7.getItens().add(new ItemComanda(null, comanda7, produto1, 1)); // 1 Hamburguer

        // Criando mais comandas para popular os gráficos
        for (int i = 1; i <= 50; i++) {
            Cliente cliente = i % 2 == 0 ? cliente1 : cliente2;
            Funcionario funcionario = i % 3 == 0 ? funcionario1 : funcionario2;
            Prioridade prioridade = i % 2 == 0 ? Prioridade.ALTA : Prioridade.MEDIA;
            Status status = i % 3 == 0 ? Status.ABERTO : (i % 2 == 0 ? Status.ENCERRADO : Status.ANDAMENTO);
            LocalDate dataAbertura = LocalDate.now().minusMonths(i % 12);  // Diferentes meses dos últimos 12 meses
            Comanda comanda = new Comanda(null, prioridade, status, "Comanda Extra " + i, "Observação " + i, cliente, funcionario, "Mesa " + i);
            comanda.setDataAbertura(dataAbertura);
            comanda.getItens().add(new ItemComanda(null, comanda, produto2, 2)); // 2 Pizzas
            comanda.getItens().add(new ItemComanda(null, comanda, produto4, 1)); // 1 Suco
            comandaRepository.save(comanda);
        }

        // Salvando todas as entidades no repositório
        comandaRepository.saveAll(Arrays.asList(comanda1, comanda2, comanda3, comanda4, comanda5, comanda6, comanda7));
    }
}
