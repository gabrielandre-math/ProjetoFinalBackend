package com.gabriel.smarorder.services;

import java.util.List;
import java.util.Optional;

import com.gabriel.smarorder.domain.dtos.ComandaDTO;
import com.gabriel.smarorder.domain.enums.Prioridade;
import com.gabriel.smarorder.domain.enums.Status;
import com.gabriel.smarorder.domain.models.Cliente;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.repositories.ComandaRepository;
import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gabriel.smarorder.domain.models.Comanda;
@Service
public class ComandaService {
    @Autowired
    private ComandaRepository comandaRepository;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ClienteService clienteService;

    public Comanda findById(Integer id) {
        Optional<Comanda> obj = comandaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado ID: " + id));
    }

    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    public Comanda create(@Valid ComandaDTO comandaDTO) {
        return comandaRepository.save(newComanda(comandaDTO));
    }
    private Comanda newComanda(ComandaDTO obj) {
        Funcionario funcionario = funcionarioService.findById(obj.getFuncionario());
        Cliente cliente = clienteService.findById(obj.getCliente());

        Comanda comanda = new Comanda();
        if(obj.getId() != null) {
            comanda.setId(obj.getId());
        }

        comanda.setFuncionario(funcionario);
        comanda.setCliente(cliente);
        comanda.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
        comanda.setStatus(Status.toEnum(obj.getStatus()));
        comanda.setTitulo(obj.getTitulo());
        comanda.setObservacoes(obj.getObservacoes());
        return comanda;
    }

}
