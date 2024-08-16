package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.dtos.ClienteDTO;
import com.gabriel.smarorder.domain.models.Cliente;
import com.gabriel.smarorder.domain.models.Pessoa;
import com.gabriel.smarorder.repositories.ClienteRepository;
import com.gabriel.smarorder.repositories.PessoaRepository;
import com.gabriel.smarorder.services.exceptions.DataIntegrityViolationException;
import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        objDTO.setId(null);
        ValidaPorCpfeEmail(objDTO);
        Cliente newObj = new Cliente(objDTO);
        return clienteRepository.save(newObj);
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = clienteRepository.findById(id).get();
        ValidaPorCpfeEmail(objDTO);
        oldObj = new Cliente(objDTO);
        return clienteRepository.save(oldObj);

    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (!obj.getComandas().isEmpty()) {
            throw new DataIntegrityViolationException("O cliente possui comanda em aberto e não pode ser deletado!");
        }
        clienteRepository.delete(obj);
    }

    private void ValidaPorCpfeEmail(ClienteDTO clienteDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(clienteDTO.getCpf());
        if (obj.isPresent() && !Objects.equals(obj.get().getId(), clienteDTO.getId())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!"); //Cuidado para não confundir com a que vem no Spring
        }
        obj = pessoaRepository.findByEmail(clienteDTO.getEmail());

        if (obj.isPresent() && !Objects.equals(obj.get().getId(), clienteDTO.getId())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }



}
