package com.gabriel.smarorder.services;

import com.gabriel.smarorder.domain.models.Funcionario;
import com.gabriel.smarorder.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
