package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.dtos.FuncionarioDTO;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario findById(Integer id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario create(FuncionarioDTO objDTO) {
        objDTO.setId(null);
        Funcionario newObj = new Funcionario(objDTO);
        return funcionarioRepository.save(newObj);
    }
}
