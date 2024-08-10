package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.models.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
}
