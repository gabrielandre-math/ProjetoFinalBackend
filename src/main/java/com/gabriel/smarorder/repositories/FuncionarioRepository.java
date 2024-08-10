package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    
}
