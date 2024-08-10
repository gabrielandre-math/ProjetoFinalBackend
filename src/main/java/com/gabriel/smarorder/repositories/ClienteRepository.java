package com.gabriel.smarorder.repositories;

import com.gabriel.smarorder.domain.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
