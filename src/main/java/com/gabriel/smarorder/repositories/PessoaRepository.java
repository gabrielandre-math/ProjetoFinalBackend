package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
