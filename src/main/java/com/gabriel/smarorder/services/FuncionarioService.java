package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.dtos.FuncionarioDTO;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.domain.models.Pessoa;
import com.gabriel.smarorder.repositories.FuncionarioRepository;
import com.gabriel.smarorder.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
import com.gabriel.smarorder.services.exceptions.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Funcionario findById(Integer id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario create(FuncionarioDTO objDTO) {
        objDTO.setId(null);
        ValidaPorCpfeEmail(objDTO);
        Funcionario newObj = new Funcionario(objDTO);
        return funcionarioRepository.save(newObj);
    }
    private void ValidaPorCpfeEmail(FuncionarioDTO funcionarioDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(funcionarioDTO.getCpf());
        if (obj.isPresent() && !Objects.equals(obj.get().getId(), funcionarioDTO.getId())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!"); //Cuidado para não confundir com a que vem no Spring
        }
        obj = pessoaRepository.findByEmail(funcionarioDTO.getEmail());

        if (obj.isPresent() && !Objects.equals(obj.get().getId(), funcionarioDTO.getId())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }
}
