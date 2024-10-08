package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.dtos.FuncionarioDTO;
import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.domain.models.Pessoa;
import com.gabriel.smarorder.repositories.FuncionarioRepository;
import com.gabriel.smarorder.repositories.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.gabriel.smarorder.services.exceptions.ObjectNotFoundException;
import com.gabriel.smarorder.services.exceptions.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder encoder;

    public Funcionario findById(Integer id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario create(FuncionarioDTO objDTO) {
        objDTO.setId(null);
        objDTO.setSenha(encoder.encode(objDTO.getSenha()));
        ValidaPorCpfeEmail(objDTO);
        Funcionario newObj = new Funcionario(objDTO);
        return funcionarioRepository.save(newObj);
    }

    public Funcionario update(Integer id, @Valid FuncionarioDTO objDTO) {
        objDTO.setId(id);
        Funcionario oldObj = funcionarioRepository.findById(id).get();
        ValidaPorCpfeEmail(objDTO);
        oldObj = new Funcionario(objDTO);
        return funcionarioRepository.save(oldObj);

    }

    public void delete(Integer id) {
        Funcionario obj = findById(id);
        if (!obj.getComandas().isEmpty()) {
            throw new DataIntegrityViolationException("O funcionário possui comanda em aberto e não pode ser deletado!");
        }
        funcionarioRepository.delete(obj);
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
