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

        // Criando Clientes com CPFs válidos (com comandas em aberto)
        Cliente cliente1 = new Cliente(null, "Pablo Andrade", "038.389.330-52", "pablo1@mail.com", encoder.encode("123"), "99992999");
        Cliente cliente2 = new Cliente(null, "Ana Beatriz", "220.411.510-05", "ana1@mail.com", encoder.encode("654321"), "98887766");
        Cliente cliente3 = new Cliente(null, "Carlos Souza", "173.195.200-79", "carlos1@mail.com", encoder.encode("789456"), "97776655");
        Cliente cliente4 = new Cliente(null, "Joa Souza", "791.703.630-80", "joa1@mail.com", encoder.encode("789456"), "97776155");
        Cliente cliente5 = new Cliente(null, "Gabriel Lima", "308.323.020-66", "gabriel1@mail.com", encoder.encode("123456"), "987654321");
        Cliente cliente6 = new Cliente(null, "Juliana Costa", "147.216.170-03", "juliana1@mail.com", encoder.encode("abcdef"), "912345678");
        Cliente cliente7 = new Cliente(null, "Marcos Silva", "981.641.520-80", "marcos1@mail.com", encoder.encode("123abc"), "987654321");
        Cliente cliente8 = new Cliente(null, "Luiza Martins", "056.907.450-90", "luiza1@mail.com", encoder.encode("321cba"), "923456789");
        Cliente cliente9 = new Cliente(null, "Fernando Lima", "813.085.810-09", "fernando1@mail.com", encoder.encode("654321"), "932165478");
        Cliente cliente10 = new Cliente(null, "Aline Ferreira", "706.342.030-53", "aline1@mail.com", encoder.encode("a1b2c3"), "941258369");
        Cliente cliente11 = new Cliente(null, "Ricardo Santos", "399.034.080-80", "ricardo1@mail.com", encoder.encode("123654"), "912345987");
        Cliente cliente12 = new Cliente(null, "Carla Almeida", "485.347.180-40", "carla1@mail.com", encoder.encode("abc123"), "913579246");
        Cliente cliente13 = new Cliente(null, "Daniel Souza", "518.485.860-19", "daniel1@mail.com", encoder.encode("654abc"), "924681357");
        Cliente cliente14 = new Cliente(null, "Patricia Gomes", "703.250.400-01", "patricia1@mail.com", encoder.encode("987cba"), "935478126");
        Cliente cliente15 = new Cliente(null, "Marcelo Almeida", "450.626.030-99", "marcelo1@mail.com", encoder.encode("1a2b3c"), "946513792");
        Cliente cliente16 = new Cliente(null, "André Costa", "944.003.530-79", "andre1@mail.com", encoder.encode("321abc"), "957894612");
        Cliente cliente17 = new Cliente(null, "Paula Mendes", "244.395.430-73", "paula1@mail.com", encoder.encode("abc321"), "968745231");
        Cliente cliente18 = new Cliente(null, "Lucas Barbosa", "628.296.380-00", "lucas1@mail.com", encoder.encode("a123b456"), "979512468");
        Cliente cliente19 = new Cliente(null, "Roberta Nunes", "111.033.040-54", "roberta1@mail.com", encoder.encode("1a2b3c4d"), "981234567");
        Cliente cliente20 = new Cliente(null, "Bruno Cardoso", "778.428.910-36", "bruno1@mail.com", encoder.encode("a1b2c3d4"), "991234578");

        cliente1.addPerfil(Perfil.CLIENTE);
        cliente2.addPerfil(Perfil.CLIENTE);
        cliente3.addPerfil(Perfil.CLIENTE);
        cliente4.addPerfil(Perfil.CLIENTE);
        cliente5.addPerfil(Perfil.CLIENTE);
        cliente6.addPerfil(Perfil.CLIENTE);
        cliente7.addPerfil(Perfil.CLIENTE);
        cliente8.addPerfil(Perfil.CLIENTE);
        cliente9.addPerfil(Perfil.CLIENTE);
        cliente10.addPerfil(Perfil.CLIENTE);
        cliente11.addPerfil(Perfil.CLIENTE);
        cliente12.addPerfil(Perfil.CLIENTE);
        cliente13.addPerfil(Perfil.CLIENTE);
        cliente14.addPerfil(Perfil.CLIENTE);
        cliente15.addPerfil(Perfil.CLIENTE);
        cliente16.addPerfil(Perfil.CLIENTE);
        cliente17.addPerfil(Perfil.CLIENTE);
        cliente18.addPerfil(Perfil.CLIENTE);
        cliente19.addPerfil(Perfil.CLIENTE);
        cliente20.addPerfil(Perfil.CLIENTE);

        // Criando Clientes sem Comandas
        Cliente cliente21 = new Cliente(null, "João Pereira", "749.118.140-63", "joao1@mail.com", encoder.encode("1q2w3e"), "923456781");
        Cliente cliente22 = new Cliente(null, "Marta Silva", "569.370.710-51", "marta1@mail.com", encoder.encode("abc987"), "934567812");
        Cliente cliente23 = new Cliente(null, "Roberto Andrade", "528.340.310-61", "roberto1@mail.com", encoder.encode("cba123"), "945678123");
        Cliente cliente24 = new Cliente(null, "Fernanda Almeida", "003.804.560-52", "fernanda1@mail.com", encoder.encode("987654"), "956789234");
        Cliente cliente25 = new Cliente(null, "Gustavo Costa", "992.044.280-15", "gustavo1@mail.com", encoder.encode("qwerty"), "967891245");
        Cliente cliente26 = new Cliente(null, "Lucia Santos", "758.866.830-03", "lucia1@mail.com", encoder.encode("password"), "978912356");
        Cliente cliente27 = new Cliente(null, "Mariana Oliveira", "803.669.380-10", "mariana1@mail.com", encoder.encode("abcdefg"), "989123467");
        Cliente cliente28 = new Cliente(null, "Felipe Lima", "460.366.620-92", "felipe1@mail.com", encoder.encode("ghijk"), "991234568");
        Cliente cliente29 = new Cliente(null, "Clara Nunes", "700.927.930-61", "clara1@mail.com", encoder.encode("lmnop"), "912345789");
        Cliente cliente30 = new Cliente(null, "Sérgio Mendes", "766.515.000-40", "sergio1@mail.com", encoder.encode("mnopq"), "923456890");
        Cliente cliente31 = new Cliente(null, "Letícia Souza", "829.928.530-54", "leticia1@mail.com", encoder.encode("pqrst"), "934567901");
        Cliente cliente32 = new Cliente(null, "Alberto Rocha", "576.770.840-10", "alberto1@mail.com", encoder.encode("tuvwx"), "945678012");
        Cliente cliente33 = new Cliente(null, "Débora Melo", "605.659.880-26", "debora1@mail.com", encoder.encode("uvwxyz"), "956789123");
        Cliente cliente34 = new Cliente(null, "Wagner Gomes", "785.691.510-20", "wagner1@mail.com", encoder.encode("xyzabc"), "967890234");
        Cliente cliente35 = new Cliente(null, "Renata Lopes", "881.284.150-34", "renata1@mail.com", encoder.encode("qazwsx"), "978901345");
        Cliente cliente36 = new Cliente(null, "Adriana Martins", "888.420.460-78", "adriana1@mail.com", encoder.encode("edcrfv"), "989012456");
        Cliente cliente37 = new Cliente(null, "Paulo Pereira", "529.823.520-44", "paulo1@mail.com", encoder.encode("plmokn"), "991123567");
        Cliente cliente38 = new Cliente(null, "Monica Silva", "345.880.160-08", "monica1@mail.com", encoder.encode("zxcvbn"), "912234678");
        Cliente cliente39 = new Cliente(null, "Gisele Souza", "698.204.800-43", "gisele1@mail.com", encoder.encode("asdfgh"), "923345789");
        Cliente cliente40 = new Cliente(null, "Fábio Mendes", "354.109.830-92", "fabio1@mail.com", encoder.encode("qwertz"), "934456890");

        cliente21.addPerfil(Perfil.CLIENTE);
        cliente22.addPerfil(Perfil.CLIENTE);
        cliente23.addPerfil(Perfil.CLIENTE);
        cliente24.addPerfil(Perfil.CLIENTE);
        cliente25.addPerfil(Perfil.CLIENTE);
        cliente26.addPerfil(Perfil.CLIENTE);
        cliente27.addPerfil(Perfil.CLIENTE);
        cliente28.addPerfil(Perfil.CLIENTE);
        cliente29.addPerfil(Perfil.CLIENTE);
        cliente30.addPerfil(Perfil.CLIENTE);
        cliente31.addPerfil(Perfil.CLIENTE);
        cliente32.addPerfil(Perfil.CLIENTE);
        cliente33.addPerfil(Perfil.CLIENTE);
        cliente34.addPerfil(Perfil.CLIENTE);
        cliente35.addPerfil(Perfil.CLIENTE);
        cliente36.addPerfil(Perfil.CLIENTE);
        cliente37.addPerfil(Perfil.CLIENTE);
        cliente38.addPerfil(Perfil.CLIENTE);
        cliente39.addPerfil(Perfil.CLIENTE);
        cliente40.addPerfil(Perfil.CLIENTE);

        // Criando Funcionários com CPFs válidos
        Funcionario funcionario1 = new Funcionario(null, "Adalmir Jr", "505.341.940-01", "adalmir@mail.com", encoder.encode("123"), "99992919");
        Funcionario funcionario2 = new Funcionario(null, "Maria Silva", "294.250.910-48", "maria@mail.com", encoder.encode("456789"), "98888777");
        Funcionario funcionario3 = new Funcionario(null, "João Mendes", "877.874.530-60", "joao@mail.com", encoder.encode("123789"), "96665544");
        Funcionario funcionario4 = new Funcionario(null, "Max Hargreeves", "412.174.780-19", "max@mail.com", encoder.encode("123789"), "96665524");

        funcionario1.addPerfil(Perfil.FUNCIONARIO);
        funcionario2.addPerfil(Perfil.FUNCIONARIO);
        funcionario3.addPerfil(Perfil.FUNCIONARIO);
        funcionario4.addPerfil(Perfil.FUNCIONARIO);

        // Criando um usuário Administrador
        Funcionario admin = new Funcionario(null, "Admin User", "654.520.190-57", "admin@mail.com", encoder.encode("admin123"), "91111222");
        admin.addPerfil(Perfil.ADMIN);

        // Criando Comandas para clientes com comandas em aberto
        Comanda comanda1 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 01", "Nenhuma Observação", cliente1, funcionario1);
        Comanda comanda2 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 02", "Adicionar pouco sal", cliente2, funcionario2);
        Comanda comanda3 = new Comanda(null, Prioridade.BAIXA, Status.ENCERRADO, "Comanda 03", "Nenhuma Observação", cliente3, funcionario3);
        Comanda comanda4 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 04", "Sem cebola", cliente1, funcionario3);
        Comanda comanda5 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 05", "Sem glúten", cliente2, funcionario1);
        Comanda comanda6 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 06", "Com carne", cliente5, funcionario2);
        Comanda comanda7 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 07", "Sem lactose", cliente6, funcionario3);
        Comanda comanda8 = new Comanda(null, Prioridade.BAIXA, Status.ENCERRADO, "Comanda 08", "Bem passada", cliente7, funcionario4);
        Comanda comanda9 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 09", "Pouca pimenta", cliente8, funcionario1);
        Comanda comanda10 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 10", "Sem açúcar", cliente9, funcionario2);
        Comanda comanda11 = new Comanda(null, Prioridade.MEDIA, Status.ANDAMENTO, "Comanda 11", "Pouco óleo", cliente10, funcionario3);
        Comanda comanda12 = new Comanda(null, Prioridade.ALTA, Status.ENCERRADO, "Comanda 12", "Sem queijo", cliente11, funcionario4);
        Comanda comanda13 = new Comanda(null, Prioridade.BAIXA, Status.ANDAMENTO, "Comanda 13", "Com molho", cliente12, funcionario1);
        Comanda comanda14 = new Comanda(null, Prioridade.MEDIA, Status.ENCERRADO, "Comanda 14", "Sem glúten", cliente13, funcionario2);
        Comanda comanda15 = new Comanda(null, Prioridade.ALTA, Status.ANDAMENTO, "Comanda 15", "Sem alho", cliente14, funcionario3);

        // Salvar todas as entidades no repositório
        funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2, funcionario3, funcionario4, admin));
        clienteRepository.saveAll(Arrays.asList(
                cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8, cliente9, cliente10,
                cliente11, cliente12, cliente13, cliente14, cliente15, cliente16, cliente17, cliente18, cliente19, cliente20,
                cliente21, cliente22, cliente23, cliente24, cliente25, cliente26, cliente27, cliente28, cliente29, cliente30,
                cliente31, cliente32, cliente33, cliente34, cliente35, cliente36, cliente37, cliente38, cliente39, cliente40
        ));
        comandaRepository.saveAll(Arrays.asList(
                comanda1, comanda2, comanda3, comanda4, comanda5, comanda6, comanda7, comanda8, comanda9, comanda10,
                comanda11, comanda12, comanda13, comanda14, comanda15
        ));
    }
}
